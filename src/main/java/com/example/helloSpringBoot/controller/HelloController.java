package com.example.helloSpringBoot.controller;

import com.example.helloSpringBoot.annotation.NeedLogin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @CrossOrigin
    @RequestMapping("/hello")
    public String HelloSpring (){
        return "hello！";
    }


    /**
     * 测试不 需要登录
     *
     * @Date: 2019/4/18 14:37
     *
     */
    @RequestMapping("/testNoLogin")
    public String testNoLogin (){
        return "调用成功，此接口不需要登录校验！-Java碎碎念！";
    }

    /**
     * 测试需要登录
     *
     * @Date: 2019/4/18 14:37
     *
     */
    @NeedLogin
    @RequestMapping("/testNeedLogin")
    public String testNeedLogin (){
        return "testNeedLogin！";
    }

    /**
     * mockTest
     *
     * @Date: 2019/4/28
     *
     */
    @RequestMapping("/mockTest")
    public String mockTest (){
        return "mockTest-Java碎碎念！";
    }
}