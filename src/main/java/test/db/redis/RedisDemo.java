package test.db.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

	public static void main(String[] args) {
		//方式一
		Jedis jedis = new Jedis("192.168.25.128",6662);
		jedis.set("hello","world");
		String value = jedis.get("hello");
		System.out.println(value);
		jedis.close();
		
		//方式二：线程池
		/*JedisPool pool = new JedisPool("192.168.25.128",6379);
		Jedis jedis1 = pool.getResource();
		String value1 = jedis1.get("hello");
		System.out.println(value1);
		jedis.close();*/
	

	}

}
