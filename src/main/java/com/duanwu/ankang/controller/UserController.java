package com.duanwu.ankang.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.duanwu.ankang.mode.User;
import com.duanwu.ankang.service.IPrimaryUserService;
import com.duanwu.ankang.service.ISecondUserService;
import com.duanwu.ankang.service.IUserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@ResponseBody
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IPrimaryUserService primaryUserService;

    @Resource
    private ISecondUserService secondUserService;

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


    @GetMapping("/addUser")
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(@RequestBody(required = false) User user){
        this.primaryUserService.addUser(user);
        int i = 1/0;
        this.secondUserService.addUser(user);
        return true;
    }
















}
