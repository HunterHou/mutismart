package com.hd.mutismart.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public ModelAndView home() {
        return new ModelAndView("welcome.ftl");
    }
}
