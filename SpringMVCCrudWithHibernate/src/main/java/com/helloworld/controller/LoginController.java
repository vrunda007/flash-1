package com.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.helloworld.domain.User;
import com.helloworld.service.ILoginService;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	@RequestMapping(value = "/showLoginPage", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelAndView modelAndView) {
		System.out.println("We are in show login method");
		modelAndView.setViewName("loginForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView checkLoginCredentials(HttpServletRequest req,HttpServletResponse res,
			ModelAndView modelAndView) {	
		
		User user = new User();
		Boolean isValidCredential = false;
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		user.setUserName(userName);
		user.setPassword(password);
		
		List<User> listUser = loginService.checkLoginCredentials();
		
		for(User  aa : listUser) {
			if(aa.getUserName().equals(userName)&&(aa.getPassword().equals(password))) {
				isValidCredential = true;
				break;
			}
			
		}
		
		modelAndView.addObject("isValidCredential", isValidCredential);

		System.out.println("We are in show checkLoginCredentials method"+userName+" "+password);
		
		if(isValidCredential) {
			modelAndView.setViewName("hello");
		}else {
			modelAndView.setViewName("loginForm");
		}
		
		return modelAndView;
	}
}



