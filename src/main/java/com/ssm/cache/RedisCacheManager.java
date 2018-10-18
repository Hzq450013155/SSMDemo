package com.ssm.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name RedisCacheManager
 * @description redis缓存管理类
 * @date 2018-10-16
 */
public class RedisCacheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
