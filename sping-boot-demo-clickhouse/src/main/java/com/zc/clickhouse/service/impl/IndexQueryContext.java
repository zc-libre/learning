package com.zc.clickhouse.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zc.clickhouse.entity.EsData;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao.cheng
 * @date 2020/9/25 15:35
 */
public class IndexQueryContext {

    private final List<EsData> esDataList;
    private final List<IndexQuery> queries;


    public IndexQueryContext(List<EsData> esDataList) {
        this.esDataList = esDataList;
        queries = Lists.newArrayList();
    }

    public List<IndexQuery> getQueries() {
        esDataList.forEach(esData -> {
            IndexQuery indexQuery = new IndexQuery();
            indexQuery.setId(String.valueOf(esData.getId()));
            indexQuery.setSource(JSON.toJSONString(esData));
            queries.add(indexQuery);
        });
        return queries;
    }
}
