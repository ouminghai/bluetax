package com.jmts.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmts.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("json")
public class JsonController {

    private static final Logger log = Logger.getLogger(JsonController.class);

    @RequestMapping("receive")
    public String Receive(
            @RequestBody User user,
            HttpServletResponse httpServletResponse


    ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        log.info(objectMapper.writeValueAsString(user));


        return "receive";
    }



    @RequestMapping("write")
    @ResponseBody
    public Object write(

    ){

        return new Object();


    }


}
