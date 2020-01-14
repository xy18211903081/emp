package com.fh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 连接池信息
 */
public class RedisPools {

    //连接信息
    private static final String HOST="192.168.203.132";
    //端口号
    private static final Integer PORT=6379;
    //最大链接数
    private static final Integer MAXTotal=100;
     //最大空闲连接数
    private static final Integer MaxIdle=10;

    private static final Integer MinIdle=5;

    //提成公共的 方便调用
   private static JedisPool jedisPool;

   private RedisPools(){};

   //静态代码块  只能执行一次
   static {
      //设置连接池的一些配置信息
      JedisPoolConfig poolConfig =new JedisPoolConfig();
      //设置最大连接数
      poolConfig.setMaxTotal(RedisPools.MAXTotal);
      //最大空闲连接数
      poolConfig.setMaxIdle(RedisPools.MaxIdle);
      //设置最小空闲连接数
      poolConfig.setMinIdle(RedisPools.MinIdle);
      //创建连接池对象         redis的 ip地址         端口号
      jedisPool=new JedisPool(RedisPools.HOST, RedisPools.PORT);
   }

   //从数据库连接池中获取一个连接信息
   public static Jedis getJedis(){
      //获取数据库的连接配置信息
      Jedis resource =jedisPool.getResource();
      return resource;
   }

   //用完之后需要换给数据库连接池  方便下次调用
   public static void returnJedis(Jedis jedis){
      //判断如果有这个数据库 就把该数据库的信息关闭
    if(jedis !=null){
      jedis.close();
    }
   }


   //删除 redis对象
    public static void delJedis(){

    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public static Boolean exists(String key) {
        Jedis jedis = getJedis();
        return jedis.exists(key);
    }

    /**
     * 删除指定的key,也可以传入一个包含key的数组
     *
     * @param keys
     * @return
     */
    public static Long del(String... keys) {
        Jedis jedis = getJedis();
        return jedis.del(keys);
    }

}
