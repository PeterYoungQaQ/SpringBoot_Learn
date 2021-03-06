package net.peter.sp.config;
/*
 * @Author: Haoran
 * @Date: 2021/3/6 9:03
 * @Description: 自定义配置类
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:config.properties"})
public class CustomConfig {

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
