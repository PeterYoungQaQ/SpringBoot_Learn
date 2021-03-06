package net.peter.sp.config;
/*
 * @Author: Haoran
 * @Date: 2021/3/6 8:53
 * @Description: 配置类
 */

import net.peter.sp.domain.VideoOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * 使用@Bean进行注解，表示这个bean交给spring进行管理
     * @return
     */
    @Bean("videoOrder")
    public VideoOrder videoOrder(){
        return new VideoOrder();
    }
}
