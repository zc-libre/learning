package com.zc.clickhouse.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.zc.clickhouse.entity.TestDataInfo;
import com.zc.clickhouse.mapper.TestMapper;
import com.zc.clickhouse.service.TestDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhao.cheng
 * @date 2020/9/15 10:54
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    AtomicLong idWorker = new AtomicLong(300000000);

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void batchInsert() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        try {
            for (int i = 0; i < 200000000; i++) {
                int num = i % 100000;
                if (num == 0) {
                    List<TestDataInfo> testData = generateData(100000);
                    if (!testData.isEmpty()) {
                        testData.forEach(mapper::insert);
                        log.info("第{}次数据插入成功！", i / 100000);
                        sqlSession.commit();
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    private List<TestDataInfo> generateData(int n) {
        List<TestDataInfo> dataList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TestDataInfo testDataInfo = new TestDataInfo();
            testDataInfo.setId(idWorker.getAndIncrement());
            testDataInfo.setName(UUID.fastUUID().toString());
            testDataInfo.setSign(RandomUtil.randomInt(0,128));
            testDataInfo.setCreateTime(System.nanoTime());
            testDataInfo.setDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
            dataList.add(testDataInfo);
        }
        return dataList;
    }
}
