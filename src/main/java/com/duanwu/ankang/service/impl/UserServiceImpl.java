package com.duanwu.ankang.service.impl;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duanwu.ankang.mapper.UserMapper;
import com.duanwu.ankang.mode.User;
import com.duanwu.ankang.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public int userTotalCount(User user) {
        return baseMapper.userTotalCount(user);
    }

    @Override
    public List<Map<String, Object>> describe(User user) {
        return baseMapper.describe(user);
    }


}
