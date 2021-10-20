package com.example.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author wangtang
 */
public class RedisTest {

	public  Jedis jedis=null;
	/**
	 * 用于返回redis
	 * @return
	 */
	public  Jedis getRedisTest(){
		Jedis jedis = new Jedis("52.77.215.91");
		return jedis;
	}



	public  String setkey(String key,String value){

		if (jedis==null){
			jedis =getRedisTest();
		}
		jedis.set(key,value);
		return  "ok";
	}

	public String  getValue(String key){
		if (jedis==null){
			jedis =getRedisTest();
		}
		return  jedis.get(key);
	}

	public  boolean isKey(String key){
		if (jedis==null){
			jedis =getRedisTest();
		}
		return  jedis.exists(key);

	}
	    public static void main(String[] args) {
	        //连接本地的 Redis 服务
	        Jedis jedis = new Jedis("52.77.215.91");
	        System.out.println("连接成功");
	        //查看服务是否运行
	        System.out.println("服务正在运行: "+jedis.ping());
	        //存储数据到列表中
	        jedis.lpush("site-list", "Runoob");
	        jedis.lpush("site-list", "Google");
	        jedis.lpush("site-list", "Taobao");
	        // 获取存储的数据并输出
	        List<String> list = jedis.lrange("site-list", 0 ,0);
	        for(int i=0; i<list.size(); i++) {
	            System.out.println("列表项为: "+list.get(i));
	        }
	        // 获取数据并输出
	        Set<String> keys = jedis.keys("*"); 
	        Iterator<String> it=keys.iterator() ;   
	        while(it.hasNext()){   
	            String key = it.next();   
	            System.out.println(key);   
	        }
	    }
}
