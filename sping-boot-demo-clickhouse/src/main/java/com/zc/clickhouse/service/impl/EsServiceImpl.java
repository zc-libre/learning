package com.zc.clickhouse.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.zc.clickhouse.entity.EsData;
import com.zc.clickhouse.mapper.EsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.elasticsearch.core.*;

import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @author zhao.cheng
 * @date 2020/9/25 9:42
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EsServiceImpl {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    AtomicLong idWorker = new AtomicLong(0);
    public void create() {


    }

    public void insertBatch() {
        for (int i = 0; i < 500000000; i++) {
            int num = i % 100000;
            if (num == 0) {
                List<EsData> esData = generateData();
                if (CollectionUtil.isNotEmpty(esData)) {
                    try {
                        IndexQueryContext indexQueryContext = new IndexQueryContext(generateData());
                        elasticsearchRestTemplate.bulkIndex(indexQueryContext.getQueries(), IndexCoordinates.of("data"));
                        log.info("第{}次数据插入成功！", i / 100000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }


    private List<EsData> generateData() {
        List<EsData> dataList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            long id = idWorker.getAndIncrement();
            EsData testDataInfo = new EsData();
            testDataInfo.setId(id);
            testDataInfo.setName(UUID.fastUUID().toString());
            testDataInfo.setSign(RandomUtil.randomInt(0,128));
            testDataInfo.setCreateTime(System.nanoTime());
            testDataInfo.setDate(new Date());
            dataList.add(testDataInfo);
        }
        return dataList;
    }
}
