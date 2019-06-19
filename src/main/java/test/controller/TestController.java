package test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.mapper.UserMapper;

@RestController
public class TestController {
	@Autowired
	UserMapper userMapper;
	@Value("${testname}")
	String testname;
	
	@RequestMapping(value="/test1")
	public Map aa(){
		
		Map map=new HashMap();
		map.put("test", testname);
		return map;
	}
	
    @RequestMapping(value="/test")
	public Map test(){
		Map map=new HashMap();
		map.put("test", "test");
		return map;
	}
    @SuppressWarnings("unchecked")
	@RequestMapping(value="find")
	public Map find(){
    	Map map=new HashMap();
    	List list=userMapper.getAll();
    	
    	map.put("student", list);
		return map;
	}

}
