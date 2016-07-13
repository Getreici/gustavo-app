package com.gustavo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gustavo.web.model.User;
import com.gustavo.web.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		
		ModelAndView model = new ModelAndView("/hello");
		model.addObject("title", "Spring Security Hello World");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		User user=userService.findById(1);
		ModelAndView model = new ModelAndView("/login");
		model.addObject("title", "Spring Security Hello World");
		model.addObject("user", user);
		//model.setViewName("login");

		return model;

	}

}