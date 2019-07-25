package com.hd.mutismart.search.entity;

import com.hd.mutismart.service.entity.User;
import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mutiSmart", type = "user")
@Data
public class EsUser extends User {

    public static String indexType="user";

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id",
                                                getId()).append("name",
                                                                getName()).append("birthday",
                                                                                  getBirthday()).append("sex",
                                                                                                        getSex()).toString();
    }
}
