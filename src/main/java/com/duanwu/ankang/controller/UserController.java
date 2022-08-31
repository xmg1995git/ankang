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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


    @GetMapping("/randomAddUser")
    @Transactional(rollbackFor = Exception.class)
    public boolean randomAddUser(){
        for (int i = 0; i < 2000; i++) {
            User user = new User();
            user.setName(String.valueOf(i));
            user.setNodes(String.valueOf(i));
            this.userService.save(user);
        }

        return true;
    }


    @GetMapping("/randomSelectUser")
    @Transactional(rollbackFor = Exception.class)
    public boolean randomSelectUser(){

        List<User> list = this.userService.lambdaQuery().list();
        List<String> collect = list.stream().map(User::getId).collect(Collectors.toList());
        System.out.println("-----------"+collect.size());
        List<User> list1 = this.userService.lambdaQuery().in(User::getId, collect).list();

        System.out.println("*********"+collect.size());
        this.userService.removeByIds(collect);
        return true;
    }
















}
