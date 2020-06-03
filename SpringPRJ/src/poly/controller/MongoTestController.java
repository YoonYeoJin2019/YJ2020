package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.service.IMongoTestService;

@Controller
public class MongoTestController {

	@Resource(name="MongoTestService")
	private IMongoTestService mongoTestService;
	
	@RequestMapping(value="mongo/test")
	@ResponseBody
	public String test(HttpServletRequest request,HttpServletResponse response) throws Exception{
	
		mongoTestService.createCollection();
	
	
	
	return "success";
	}
	
	
}
