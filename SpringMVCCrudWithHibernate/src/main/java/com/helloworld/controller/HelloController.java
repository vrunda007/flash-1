package com.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloworld.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService; 
		
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(Model model) {
		System.out.println("Welcome User is invoked");
		model.addAttribute("message", helloService.returnUserName());		
		return "hello";
	}	
}
