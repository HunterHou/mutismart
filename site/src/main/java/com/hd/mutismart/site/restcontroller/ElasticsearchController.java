package com.hd.mutismart.site.restcontroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.mutismart.base.annotation.Log;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.search.service.IEsUserService;

import io.swagger.annotations.ApiOperation;

/**
 * @author hunter
 */
@RestController
public class ElasticsearchController {

    @Resource
    private IEsUserService esUserService;

    @GetMapping("es/sync")
    @Log("搜索同步")
    @ApiOperation(value = "搜索同步")
    public ReqResult sync() {

        return esUserService.sync();
    }

    @GetMapping("es/clear")
    @Log("搜索清空")
    @ApiOperation(value = "搜索清空")
    public ReqResult clear() {
        return esUserService.clear();
    }

    @GetMapping("es/search")
    @Log("搜索查询")
    @ApiOperation(value = "搜索查询")
    public ReqResult search(EsUser user) {
        return esUserService.search(user);
    }
}
