package com.zc.es;

import com.zc.es.mapper.EsRepository;
import com.zc.es.service.EsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsDemoApplicationTests {

    @Autowired
    private EsServiceImpl esService;

    @Autowired
    private EsRepository esRepository;

    @Test
    void contextLoads() {
        esService.insertBatch();
    }

    @Test
    void delete() {
        esRepository.deleteAll().block();
    }

}
