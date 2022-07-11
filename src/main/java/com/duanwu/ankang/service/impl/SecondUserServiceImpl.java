package com.duanwu.ankang.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duanwu.ankang.mapper.UserMapper;
import com.duanwu.ankang.mode.User;
import com.duanwu.ankang.service.IPrimaryUserService;
import com.duanwu.ankang.service.ISecondUserService;
import com.duanwu.ankang.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@DS(value = "second")
@Service
public class SecondUserServiceImpl extends ServiceImpl<UserMapper, User> implements ISecondUserService {


    @Override
    public int userTotalCount(User user) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> describe(User user) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        User user1 = new User();
        user1.setName(UUID.randomUUID().toString().substring(0,3));
        user1.setNodes("second");
        return this.save(user1);
    }




}
