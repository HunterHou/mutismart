package com.hd.mutismart.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.search.service.IEsUserService;
import com.hd.mutismart.search.utils.UserConvert;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EsUserServiceImpl implements IEsUserService {

    @Resource
    private IUserService        userService;
    @Resource(name = "highLevelClient")
    private RestHighLevelClient restClientBuilder;

    @Override
    public ReqResult save(EsUser user) {

        IndexRequest indexRequest = new IndexRequest("mutismart", EsUser.indexType, user.getId().toString());
        try {
            indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
            IndexResponse response = restClientBuilder.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("创建索引失败", e);
            return ReqResult.fail("创建索引失败");
        }
        return ReqResult.success();
    }

    @Override
    public ReqResult save(List<EsUser> users) {
        BulkRequest bulkRequest = new BulkRequest();
        try {
            for (EsUser esUser : users) {
                IndexRequest indexRequest = new IndexRequest("mutismart", EsUser.indexType, esUser.getId().toString());
                indexRequest.source(JSON.toJSONString(esUser), XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            restClientBuilder.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("创建索引失败", e);
            return ReqResult.fail("创建索引失败");
        }
        return ReqResult.success();
    }

    @Override
    public ReqResult update(EsUser user) {
        UpdateRequest updateRequest = new UpdateRequest("mutismart", EsUser.indexType, user.getId().toString());
        try {
            updateRequest.doc(JSON.toJSONString(user));
            UpdateResponse response = restClientBuilder.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("创建索引失败", e);
            return ReqResult.fail("创建索引失败");
        }
        return ReqResult.success();
    }

    @Override
    public ReqResult delete(EsUser user) {
        DeleteRequest deleteRequest = new DeleteRequest("mutismart");
        deleteRequest.type(EsUser.indexType);
        deleteRequest.id(user.getId().toString());
        try {
            restClientBuilder.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReqResult.success();
    }

    @Override
    public ReqResult search(EsUser user) {
        if (user == null) {
            user = new EsUser();
        }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (StringUtils.isNotBlank(user.getName())) {
            QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery(user.getName());
            queryStringQueryBuilder.queryName("name");
            queryStringQueryBuilder.analyzeWildcard(true);
            queryBuilder.must(queryStringQueryBuilder);
        }
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from((user.getPage() >= 1 ? (user.getPage() - 1) : 0) * user.getSize());
        searchSourceBuilder.size(user.getSize());
        List<EsUser> esUsers = new ArrayList<>();
        try {
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices("mutismart");
            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = restClientBuilder.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit searchHit : searchResponse.getHits().getHits()) {
                EsUser esUser = JSON.parseObject(searchHit.getSourceAsString(), EsUser.class);
                esUsers.add(esUser);
            }
        } catch (IOException e) {
            log.error("搜索User", e);
        }
        return ReqResult.success(esUsers);
    }

    @Override
    public ReqResult clear() {

        try {
            DeleteIndexRequest deleteRequest = new DeleteIndexRequest("mutismart");
            restClientBuilder.indices().delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("清空User", e);
        }
        return ReqResult.success();
    }

    @Override
    public ReqResult sync() {
        List<User> users = userService.query(null);
        this.save(UserConvert.convert(users));
        return ReqResult.success();
    }
}
