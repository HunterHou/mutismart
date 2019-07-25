package com.hd.mutismart.base.page;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * @author hunter
 */
@Configuration
@MapperScan(basePackages = { "com.hd.mutismart.*.mapper" })
public class MybatisPlusPageConfig {

    @Bean
    public PaginationInterceptor PaginationInterceptor() {
        return new PaginationInterceptor();
    }
}
