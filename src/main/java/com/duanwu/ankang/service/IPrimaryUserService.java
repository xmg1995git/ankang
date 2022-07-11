package com.duanwu.ankang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duanwu.ankang.mode.User;

import java.util.List;
import java.util.Map;

public interface IPrimaryUserService extends IService<User> {

    int userTotalCount(User user);

    List<Map<String, Object>> describe(User user);

    public boolean addUser(User user);


}
