package com.duanwu.ankang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class HelloController {


    @GetMapping("/")
    public String hello(){
        return "Hello Springboot!";
    }



}
