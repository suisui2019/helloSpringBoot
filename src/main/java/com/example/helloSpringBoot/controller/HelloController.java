package com.example.helloSpringBoot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @CrossOrigin
    @RequestMapping("/hello")
    public String HelloSpring (){
        return "hello Java碎碎念！";
    }
}