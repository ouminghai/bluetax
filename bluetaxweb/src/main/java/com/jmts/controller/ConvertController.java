package com.jmts.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("convert")
public class ConvertController {


    private static final Logger log = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = {RequestMethod.POST, RequestMethod.GET})
    public void hello(HttpServletRequest request, HttpServletResponse response) {



    }


}
