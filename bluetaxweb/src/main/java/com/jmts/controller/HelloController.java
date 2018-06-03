package com.jmts.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    private static final Logger log = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response){

        log.info(request.getHeader("User-Agent"));
        log.info("hello 方法被调用");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","HelloWorld");

        modelAndView.setViewName("/hello");

        return modelAndView;
    }

}

