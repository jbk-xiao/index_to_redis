package com.weibo.index;

import redis.clients.jedis.Jedis;

public class WriteDataIntoRedis {
    public static void main(String[] args){
//        Jedis jedis = new Jedis("192.168.1.108", 6479);
//        jedis.auth("nopassword");
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
        System.out.println("传入的参数是:"+args[0]);
        jedis.close();
    }
}
