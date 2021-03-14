package net.peter.ssm.utils;
/*
 * @Author: Haoran
 * @Date: 2021/3/14 9:51
 * @Description: 基础缓存类
 */

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class BaseCache {

    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //设置缓存初始⼤大⼩小，应该合理理设置，后续会扩容
            .initialCapacity(10)
            //最⼤大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)
            //缓存过期时间，写⼊入后10分钟过期
            .expireAfterWrite(600,TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }

}
