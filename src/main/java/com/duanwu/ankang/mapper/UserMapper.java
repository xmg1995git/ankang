package com.duanwu.ankang.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.duanwu.ankang.mode.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select count(1) from xmg_user")
    int userTotalCount(User user);

    List<Map<String, Object>> describe(User user);













}
