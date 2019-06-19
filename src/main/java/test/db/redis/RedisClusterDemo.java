package test.db.redis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisClusterDemo {
	public static void main(String[] args) throws Exception {
		 //集群
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.25.128",6661));
        nodes.add(new HostAndPort("192.168.25.128",6662));
        nodes.add(new HostAndPort("192.168.25.128",6663));
        nodes.add(new HostAndPort("192.168.25.128",6664));
        nodes.add(new HostAndPort("192.168.25.128",6665));
        nodes.add(new HostAndPort("192.168.25.128",6666));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("cluster","我们六个人");
        cluster.expire("cluster", 1);
        String value = cluster.get("cluster11");
        System.out.println(value);
        try {
			Thread.sleep(2000);
			String value1 = cluster.get("cluster");
		    boolean keyExist = cluster.exists("cluster");
			System.out.println(value1+":"+keyExist);
			int i=1/0;
		} catch (Exception e) {
			
		}finally{
	        try {
	        	System.out.println("关闭了流");
				cluster.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

	}
}
