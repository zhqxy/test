package test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
	@Value("${testname}")
	String tesstname;
	@Test
	public void aa(){
		
		System.out.println(tesstname);
		System.out.println("aa");
	}
	
}
