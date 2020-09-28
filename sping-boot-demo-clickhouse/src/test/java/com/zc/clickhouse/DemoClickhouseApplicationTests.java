package com.zc.clickhouse;

import com.zc.clickhouse.entity.EsData;
import com.zc.clickhouse.mapper.EsRepository;
import com.zc.clickhouse.service.TestDataService;
import com.zc.clickhouse.service.impl.EsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.Optional;

@SpringBootTest
class DemoClickhouseApplicationTests {

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private EsServiceImpl esService;

    @Autowired
    private EsRepository repository;

    @Test
    void contextLoads() {
        testDataService.batchInsert();
    }


    @Test
    void esCreate() {
        esService.create();

    }

    @Test
    void insert() {
        esService.insertBatch();
    }

    @Test
    void find() {
        Mono<Long> count = repository.count();
        Long num = count.block();
        System.out.println(num);
    }

    @Test
    void delete() {
        Disposable subscribe = repository.deleteAll().subscribe();
        subscribe.dispose();
        System.out.println(subscribe.isDisposed());

    }

}
