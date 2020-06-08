package com.weibo.index;

import redis.clients.jedis.Jedis;

import java.io.*;

public class WriteDataIntoRedis {
    public static void main(String[] args) throws FileNotFoundException {
//        Jedis jedis = new Jedis("192.168.1.108", 6479);
//        jedis.auth("nopassword");
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        System.out.println(jedis.ping());
        System.out.println("The index is "+args[0]);
        System.out.println("The index file is "+args[1]);
        File in = new File(args[1]);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
        try{
            String id = br.readLine();
            while (id != null ){
                System.out.println(id);
                id = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

//        jedis.close();
    }
}