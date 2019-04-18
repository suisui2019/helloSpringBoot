package com.example.helloSpringBoot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @Auther: Java碎碎念
 * @Date: 2019/4/18 14:01
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
    private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 自定义拦截器，添加拦截路径和排除拦截路径
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
	}
}