package com.hd.mutismart.base.page;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hunter
 */
@Configuration
@MapperScan(basePackages = {"com.hd.mutismart.*.mapper"})
public class MybatisPlusPageConfig {

    @Bean
    public PaginationInterceptor PaginationInterceptor() {
        return new PaginationInterceptor();
    }
}
