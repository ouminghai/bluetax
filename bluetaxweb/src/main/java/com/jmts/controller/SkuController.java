package com.jmts.controller;


import com.jmts.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="sku")

@SessionAttributes("user")
public class SkuController {

    private static final Logger log = Logger.getLogger(HelloController.class);

    private static List<User> userlist;

    public SkuController(){

        super();
        userlist = new ArrayList<>();
    }


    @ModelAttribute
    public void userModel(String loginname,String password,Model model){

        log.info("userModel");

        User user = new User();

        user.setuId(222);
        user.setuName("ouminghai");
        user.setuPassword("123124");

        model.addAttribute(user);
    }

    @ModelAttribute("loginname")
    public User userModel3(@RequestParam("loginname") String loginname,@RequestParam("password")String password){

        log.info("userModel");

        User user = new User();

        user.setuId(222);
        user.setuName("ouminghai");
        user.setuPassword("123124");

        return user;

    }

    @ModelAttribute
    public String userModel2(@RequestParam("loginname") String loginname){

        return loginname;

    }



    @RequestMapping(
            value="register",
            name="register",
            method= {RequestMethod.GET,RequestMethod.POST},
         //   consumes = "text/html",
        //    produces = "application/json",
            params="name=2"
          //  headers="Referer=http://baidu.com"
    )
    public String register(HttpServletRequest request, HttpSession session,Model model){


        User user = (User)model.asMap().get("user");

        session.setAttribute("user",user);

        log.info(user);



        return "register";

    }

    @RequestMapping("login")

    public String login(
            @RequestParam(value= "loginname",required = true,defaultValue = "ouminghai") String loginname,
            @RequestParam("password") String password,
            Model model,
            @PathVariable Integer userid,
            @RequestHeader("User-Agent") String useragent,
            @CookieValue(value="JESSIONID") String sessionID
            ){


        for(User user: userlist){

            if(user.getuName().equals("ou")){
                model.addAttribute("user",user);
                return "welcome";
            }
        }


        return "usercenter/login";
    }


}
