package com.ssm.cache;

import com.ssm.util.JedisUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name RedisCache
 * @description
 * @date 2018-10-16
 */
@Component
public class RedisCache<K, V> implements Cache<K, V> {
    private final Logger logger = Logger.getLogger(RedisCache.class);

    @Resource
    JedisUtil jedisUtil;

    private final String CACHE_PREFIX = "ssm-cache:";

    private byte[] getKey(K k) {
        if (k instanceof String) {
            return (CACHE_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    public V get(K k) throws CacheException {
        logger.info("=============从缓存中获取权角色信息================");
        byte[] value = jedisUtil.get(getKey(k));
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtil.set(key, value);
        jedisUtil.expire(key, 600);
        return v;
    }

    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = jedisUtil.get(key);
        jedisUtil.del(key);
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public void clear() throws CacheException {

    }

    public int size() {
        return 0;
    }

    public Set<K> keys() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }
}
