package com.hd.mutismart.search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.search.service.IEsUserService;
import com.hd.mutismart.search.utils.UserConvert;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;

@Service
public class EsUserServiceImpl implements IEsUserService {

    @Resource
    private IUserService        userService;
    @Resource(name = "highLevelClient")
    private RestHighLevelClient restClientBuilder;

    @Override
    public ReqResult save(EsUser user) {
        BulkRequest bulkRequest = new BulkRequest();
        // restClientBuilder.bulk(bulkRequest, options);
        return ReqResult.success();
    }

    @Override
    public ReqResult save(List<EsUser> users) {
        // esUserMapper.saveAll(users);
        return ReqResult.success();
    }

    @Override
    public ReqResult update(EsUser user) {
        // esUserMapper.save(user);
        return ReqResult.success();
    }

    @Override
    public ReqResult delete(EsUser user) {
        // esUserMapper.delete(user);
        return ReqResult.success();
    }

    @Override
    public ReqResult search(EsUser user) {
        BoolQueryBuilder searchQuery = QueryBuilders.boolQuery();
        if (StringUtils.isNotBlank(user.getName())) {
            searchQuery.must(QueryBuilders.fuzzyQuery("name", user.getName()));
        }
        Pageable pageable = PageRequest.of(user.getPage(), user.getSize());
        // Page<EsUser> response = esUserMapper.search(searchQuery, pageable);
        ReqResult result = ReqResult.success();
        // result.setData(response);
        return result;
    }

    @Override
    public ReqResult clear() {
        // esUserMapper.deleteAll();
        return ReqResult.success();
    }

    @Override
    public ReqResult sync() {
        List<User> users = userService.query(null);
        this.save(UserConvert.convert(users));
        return ReqResult.success();
    }
}
