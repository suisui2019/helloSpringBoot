package com.example.helloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/set")
    public String HelloSpring (String key,String value){
        redisTemplate.opsForValue().set(key,value);
        return String.format("redis set成功！key=%s,value=%s",key,value);
    }

    @RequestMapping("/get")
    public String HelloSpring (String key){
        String value = (String) redisTemplate.opsForValue().get(key);
        return "redis get结果 value=" + value;
    }
}