package com.hd.mutismart.search.mapper;

import com.hd.mutismart.search.entity.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsUserMapper extends ElasticsearchRepository<EsUser, Long> {
}
