package net.peter.sp.aop;
/*
 * @Author: Haoran
 * @Date: 2021/3/6 9:40
 * @Description: 用于让spring扫描到AOP
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("net.peter.sp")
@EnableAspectJAutoProxy
public class AnnotationAppConfig {
}
