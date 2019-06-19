package test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class CustomContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("监听到容器启动了");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("监听到容器被销毁了");
		
	}

}
