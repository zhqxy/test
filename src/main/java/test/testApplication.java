package test;



import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.MultipartConfigElement;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
@ServletComponentScan(basePackages = "test.*")
@MapperScan("test.mapper")
@EnableJms
public class testApplication {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(testApplication.class, args);
    }
	
	/**
	 * @deprecated 创建一个Bean对象交给Sping管理AtuoWired注入即可,
	 *             test.queue为在管理端创建的队列名
	 * @return   new ActiveMQQueue("test.queue")
	 *   点对点模式
	 */
	@Bean
	public Queue queue(){
		
		return new ActiveMQQueue("test.queue");
		
	}
	/**
	 * @deprecated 发布订阅模式
	 * @return
	 */
	@Bean
	public Topic topic(){
		
		return new ActiveMQTopic("test.queue");
		
	}
	/**
	 * @deprecated  修改工厂，使其同时支持点对点和发布订阅模式
	 *            
	 * @return
	 * 
	 */
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
	        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
	        bean.setPubSubDomain(true);
	        bean.setConnectionFactory(activeMQConnectionFactory);
	        return bean;
	}
	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//设置单个大小
		factory.setMaxFileSize("10240KB");
		//设置总大小
		factory.setMaxRequestSize("10240KB");
		MultipartConfigElement mutilpart=factory.createMultipartConfig();
		return mutilpart;
	}
}
