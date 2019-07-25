package com.hd.mutismart.site.controller;

import com.hd.mutismart.base.annotation.Log;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.search.service.IEsUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hunter
 */
@RestController
public class ElasticsearchController {

    @Resource
    private IEsUserService esUserService;

    @RequestMapping("es/sync")
    public ReqResult sync() {

        return esUserService.sync();
    }

    @RequestMapping("es/clear")
    public ReqResult clear() {
        return esUserService.clear();
    }

    @RequestMapping("es/search")
    @Log("搜索查询")
    public ReqResult search(EsUser user) {
        return esUserService.search(user);
    }
}
