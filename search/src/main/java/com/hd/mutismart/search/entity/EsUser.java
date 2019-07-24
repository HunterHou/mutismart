package com.hd.mutismart.search.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import com.hd.mutismart.service.entity.User;

import lombok.Data;

@Document(indexName = "mutiSmart" ,type="user")
@Data
public class EsUser extends User {

}
