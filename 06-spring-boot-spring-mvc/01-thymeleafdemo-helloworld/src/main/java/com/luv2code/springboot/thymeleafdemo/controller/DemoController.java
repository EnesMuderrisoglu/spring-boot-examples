package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping ("/hello")
    public String sayHello(Model theModel){

        theModel.addAttribute("theDate",java.time.LocalDateTime.now());
        return "helloworld";
    }

}
