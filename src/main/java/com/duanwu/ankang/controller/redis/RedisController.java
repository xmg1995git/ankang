package com.duanwu.ankang.controller.redis;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
public class RedisController {

    private static List<Object> list = new ArrayList<>();

    @Resource
    private RedisTemplate redisCacheTemplate;


    @GetMapping("/add-string")
    public String hello(){
        ValueOperations valueOperations = redisCacheTemplate.opsForValue();
        valueOperations.set("k1", "v1");
        return "添加了一个string类型的值";
    }

    @GetMapping("/get-string")
    public String getString(){
        ValueOperations valueOperations = redisCacheTemplate.opsForValue();
        Object k1 = valueOperations.get("k1");
        return k1.toString();
    }
}
