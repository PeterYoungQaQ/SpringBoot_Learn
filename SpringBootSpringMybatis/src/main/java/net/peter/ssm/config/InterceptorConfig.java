package net.peter.ssm.config;
/*
 * @Author: Haoran
 * @Date: 2021/3/12 8:59
 * @Description: 拦截器配置类
 */

import net.peter.ssm.interceptor.CorsInterceptor;
import net.peter.ssm.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * 不用权限可以访问url： api/v1/pub/
 * 需要权限访问的url： api/v1/pri/
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(corsInterceptor()).addPathPatterns("/api/v1/pri/*/*/**");

        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
        //不不拦截哪些路路径 斜杠⼀一定要加
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
