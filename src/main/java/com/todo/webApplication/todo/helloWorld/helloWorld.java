package com.todo.webApplication.todo.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class helloWorld {
	
//	@RequestMapping(method=RequestMethod.GET,path="/hello")
//	public String helloworld()
//	{
//		return "hello world application";
//	}

	@GetMapping(path="/")
	public helloWorldBean helloworld()
	{
		return new helloWorldBean("hello world");
	}



}
