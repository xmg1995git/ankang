package com.duanwu.ankang.controller;

import com.duanwu.ankang.mode.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class UserJsonMixinController {

    @GetMapping("/jsonMixin")
    public User hello(){
        return new User("123", "abc", "modes");
    }
}


