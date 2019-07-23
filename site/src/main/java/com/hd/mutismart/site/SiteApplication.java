package com.hd.mutismart.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@MapperScan(basePackages = {"com.hd.mutismart.*.mapper"})
@EnableElasticsearchRepositories(basePackages = {"com.hd.mutismart.search.mapper"})
@ComponentScan(basePackages = {"com.hd.mutismart"})
public class SiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }
}
