import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name TestRedis
 * @description redis测试
 * @date 2018-10-09
 */
public class TestRedis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        //设置 redis 字符串数据
//        for (int i = 0 ;i<1000000;i++){
//            jedis.set("runoobkey"+i, "www.runoob.com"+i);
//        }
        jedis.flushAll();
        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));


//        jedis.lpush("site-list", "Runoob");
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Taobao");
//        // 获取存储的数据并输出
//        List<String> list = jedis.lrange("site-list", 0 ,2);
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("列表项为: "+list.get(i));
//        }
    }
}
