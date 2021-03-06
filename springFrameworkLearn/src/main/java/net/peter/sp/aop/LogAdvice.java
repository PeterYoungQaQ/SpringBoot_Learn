package net.peter.sp.aop;
/*
 * @Author: Haoran
 * @Date: 2021/3/6 9:33
 * @Description: 使用注解的方式使用AOP切面
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
// 告诉spring这是一个侧面类，里面可以定义切入点和通知
@Aspect
public class LogAdvice {

    @Pointcut("execution(* net.peter.sp.service.VideoServiceImpl.*(..))")
    public void aspect() {
    }

    @Before("aspect()")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("Log advice before log");
    }

    @After("aspect()")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("Log advice after log");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "aspect()")
    public void around(JoinPoint joinPoint) {


        Object target = joinPoint.getTarget().getClass().getName();

        System.out.println("调用者: " + target);

//        Object [] args = joinPoint.getArgs();
//
//        // 通过joinPoint获取参数
//        System.out.println("参数: " + args[0]);

        long start = System.currentTimeMillis();
        System.out.println("环绕通知，环绕前");

        try {
            Thread.sleep(201);
            ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("环绕通知，环绕后");

        System.out.println("方法前后总的耗时: " + (end - start) + "ms");

    }

}
