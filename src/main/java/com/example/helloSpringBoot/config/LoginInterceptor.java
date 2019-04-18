package com.example.helloSpringBoot.config;

import com.example.helloSpringBoot.annotation.NeedLogin;
import com.example.helloSpringBoot.util.WxUserInfoContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @Auther: Java碎碎念
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            NeedLogin needLogin = ((HandlerMethod) handler).getMethodAnnotation(NeedLogin.class);
            if (null == needLogin) {
                needLogin = ((HandlerMethod) handler).getMethod().getDeclaringClass()
                        .getAnnotation(NeedLogin.class);
            }
            // 有登录验证注解，则校验登录
            if (null != needLogin) {
                WxUserInfoContext curUserContext = (WxUserInfoContext) request.getSession()
                        .getAttribute("curUserContext");
                //如果session中没有，表示没登录
                if (null == curUserContext) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("未登录！");
                    return false;
                }
            }

        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}