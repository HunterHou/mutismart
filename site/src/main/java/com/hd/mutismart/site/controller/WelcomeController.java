package com.hd.mutismart.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;

@Controller
public class WelcomeController {

    @GetMapping("welcome")
    @ApiOperation(value = "首页")
    public String home() {
        return "index";
    }
}
