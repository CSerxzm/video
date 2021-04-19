package com.xzm.video.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类，使用之前请确保RedisTemplate成功注入
 */

public final class RedisUtils {

    private RedisUtils() {
    }

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 判断该键是否存在
     * @param key
     * @return
     */
    public boolean isEmpty(String key){
        Boolean result = redisTemplate.hasKey(key);
        return  ! result;
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(String key,long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(String key,long timeout,TimeUnit unit) {

        Boolean ret = redisTemplate.expire(key, timeout, unit);
        return ret != null && ret;
    }

    /**
     * 删除单个key
     *
     * @param key 键
     * @return true=删除成功；false=删除失败
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除多个key
     *
     * @param keys 键集合
     * @return 成功删除的个数
     */
    public void del(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 存入普通对象
     *
     * @param key Redis键
     * @param value 值
     */
    public void set(String key,Object value) {
        redisTemplate.opsForValue().set(key, value, 60, TimeUnit.MINUTES);
    }

    // 存储普通对象操作

    /**
     * 存入普通对象
     *
     * @param key 键
     * @param value 值
     * @param timeout 有效期，单位秒
     */
    public void set(String key,Object value,long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 将键值对的值进行自增操作
     * @param key 键
     * @param increment 增量
     * @return
     */
    public Object incrby(String key ,long increment){
        Long increment1 = redisTemplate.opsForValue().increment(key, increment);
        return increment;
    }

    /**
     * 获取普通对象
     *
     * @param key 键
     * @return 对象
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 存储Hash操作

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
    public void hPut(String key,String hKey,Object value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 往Hash中存入多个数据
     *
     * @param key Redis键
     * @param values Hash键值对
     */
    public void hPutAll(String key,Map<String, Object> values) {
        redisTemplate.opsForHash().putAll(key, values);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public Object hGet(String key,String hKey) {
        return redisTemplate.opsForHash().get(key, hKey);
    }

    /**
     * 对hash某个字段自增
     * @param key
     * @param hKey
     * @return
     */
    public Object hIncrement(String key,String hKey){
        Long increment = redisTemplate.opsForHash().increment(key, hKey, 1);
        return increment;
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public List<Object> hMultiGet(String key,Collection<Object> hKeys) {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    // 存储Set相关操作

    /**
     * 往Set中存入数据
     *
     * @param key Redis键
     * @param values 值
     * @return 存入的个数
     */
    public long sSet(String key,Object... values) {
        Long count = redisTemplate.opsForSet().add(key, values);
        return count == null ? 0 : count;
    }

    /**
     * 删除Set中的数据
     *
     * @param key Redis键
     * @param values 值
     * @return 移除的个数
     */
    public long sDel(String key,Object... values) {
        Long count = redisTemplate.opsForSet().remove(key, values);
        return count == null ? 0 : count;
    }

    // 存储List相关操作

    /**
     * 往List中存入数据
     *
     * @param key Redis键
     * @param value 数据
     * @return 存入的个数
     */
    public long lPush(String key,Object value) {
        Long count = redisTemplate.opsForList().rightPush(key, value);
        return count == null ? 0 : count;
    }

    /**
     * 往List中存入多个数据
     *
     * @param key Redis键
     * @param values 多个数据
     * @return 存入的个数
     */
    public long lPushAll(String key,Collection<Object> values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        return count == null ? 0 : count;
    }

    /**
     * 往List中存入多个数据
     *
     * @param key Redis键
     * @param values 多个数据
     * @return 存入的个数
     */
    public long lPushAll(String key,List<Object> values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        return count == null ? 0 : count;
    }

    /**
     * 从List中获取begin到end之间的元素
     *
     * @param key Redis键
     * @param start 开始位置
     * @param end 结束位置（start=0，end=-1表示获取全部元素）
     * @return List对象
     */
    public List<Object> lGet(String key,int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获得某个前缀的key集合
     * @param prefix
     * @return
     */
    public Set<String> getKeys(String prefix){
        Set keys = redisTemplate.keys(prefix);
        return keys;
    }
    
}
