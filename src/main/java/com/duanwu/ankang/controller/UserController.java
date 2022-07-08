package com.duanwu.ankang.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.duanwu.ankang.mode.User;
import com.duanwu.ankang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class UserController {

    @Autowired
    private IUserService userService;

    @DS(value = "primary")
    @GetMapping("/primary/userTotalCount")
    public int userTotalCountByPrimary(@RequestBody(required = false) User user){
        return userService.userTotalCount(user);
    }

    @DS(value = "second")
    @GetMapping("/second/userTotalCount")
    public int userTotalCountBySecond(@RequestBody(required = false) User user){
        return userService.userTotalCount(user);
    }








}
