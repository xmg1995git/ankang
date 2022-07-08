package com.duanwu.ankang.service;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duanwu.ankang.mode.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IUserService extends IService<User> {

    int userTotalCount(User user);

    List<Map<String, Object>> describe(User user);


}
