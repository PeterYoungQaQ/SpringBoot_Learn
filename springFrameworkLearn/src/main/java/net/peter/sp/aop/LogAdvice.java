package net.peter.sp.aop;
/*
 * @Author: Haoran
 * @Date: 2021/3/6 9:33
 * @Description: 使用注解的方式使用AOP切面
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
// 告诉spring这是一个侧面类，里面可以定义切入点和通知
@Aspect
public class LogAdvice {

    @Pointcut("execution(* net.peter.sp.service.VideoServiceImpl.*(..))")
    public void aspect(){}

    @Before("aspect()")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println("Log advice before log");
    }

    @After("aspect()")
    public void afterLog(JoinPoint joinPoint){
        System.out.println("Log advice after log");
    }
}
