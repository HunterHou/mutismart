package com.hd.mutismart.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping("welcome")
    public ModelAndView home() {
        return new ModelAndView("welcome.ftl");
    }
}
