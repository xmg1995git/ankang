package com.duanwu.ankang.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duanwu.ankang.mapper.UserMapper;
import com.duanwu.ankang.mode.User;
import com.duanwu.ankang.service.IPrimaryUserService;
import com.duanwu.ankang.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@DS(value = "primary")
@Service
public class PrimaryUserServiceImpl extends ServiceImpl<UserMapper, User> implements IPrimaryUserService {


    @Override
    public boolean addUser(User user) {
        User user1 = new User();
        user1.setName(UUID.randomUUID().toString().substring(0,3));
        user1.setNodes("primary");
        return this.save(user1);
    }


    @Override
    public int userTotalCount(User user) {
        return baseMapper.userTotalCount(user);
    }

    @Override
    public List<Map<String, Object>> describe(User user) {
        return baseMapper.describe(user);
    }


}
