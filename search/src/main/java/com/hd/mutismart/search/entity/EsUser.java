package com.hd.mutismart.search.entity;

import com.hd.mutismart.service.entity.User;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mutiSmart" ,type="user")
@Data
public class EsUser extends User {
}
