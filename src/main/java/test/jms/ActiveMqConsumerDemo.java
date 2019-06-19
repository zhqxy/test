package test.jms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class ActiveMqConsumerDemo {
	/**
	 * @deprecated 实时监听对应的队列,即时网络断开后也能载之后或取值
	 * @param text
	 */
	@JmsListener(destination = "test.queue")
    public void  Consumer1(String text){
		System.out.println("我收到的消息1:"+text);  	
    	
    }
	@JmsListener(destination = "test.queue")
    public void  Consumer2(String text){
		System.out.println("我收到了的消息2:"+text);  	
    	
    }
	/**
	 * 同时接收点对点和发布订阅模式发送过来的消息
	 * @param text
	 */
	@JmsListener(destination = "test.queue",containerFactory="jmsListenerContainerTopic")
    public void  Consumer3(String text){
		System.out.println("我收到了的消息3"+text);  	
    	
    }
}
