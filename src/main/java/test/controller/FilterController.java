package test.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${testname}")
	String testname;
	
	@RequestMapping(value="/api/a")
	public Map aa(){
		
		Map map=new HashMap();
		map.put("test", "filter");
		return map;
	}

}
