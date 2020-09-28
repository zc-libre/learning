package com.zc.es.mapper;

import com.zc.es.pojo.EsData;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhao.cheng
 * @date 2020/9/25 16:12
 */

public interface EsRepository extends ReactiveElasticsearchRepository<EsData, Long> {
}
