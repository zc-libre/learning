package com.zc.clickhouse.mapper;

import com.zc.clickhouse.entity.EsData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

import java.util.Optional;

/**
 * @author zhao.cheng
 * @date 2020/9/25 11:46
 */

public interface EsRepository extends ReactiveElasticsearchRepository<EsData,Long> {

}
