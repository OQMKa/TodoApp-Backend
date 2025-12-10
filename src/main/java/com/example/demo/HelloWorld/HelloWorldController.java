package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	//GET
	//URI - /hello-world
	//method = "helloW()
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "hello there!..";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello There Bean!-changed2");
//		throw new RuntimeException("Some error has happened don't know whyyy!");
	}

	@GetMapping(path ="/hello-world-bean/users/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}
	

}
