package test.jms;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ActiveMqProducerDemo {
	@Autowired
    Queue queue;   //点对点模型发送
	@Autowired
    Topic topic;
    @Autowired
	private JmsMessagingTemplate jmsTemplate; //用来发送消息到broker的对象
    @RequestMapping(value="product")
    public Object  product(){
    	//第一个参数是：发送到的队列,第二个参数是：发送的内容
    	jmsTemplate.convertAndSend(queue, "测试点对点模型发送");
		return "点对点发送状态:200";
    	
    }
    @RequestMapping(value="product1")
    public Object  product1(){
    	//第一个参数是：发送到的队列,第二个参数是：发送的内容
    	jmsTemplate.convertAndSend(topic, "测试发布订阅模型发送");
		return "发布订阅发送状态:200";
    	
    }
    
    
}
