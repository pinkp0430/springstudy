package com.wind.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	//@Autowired
	//private SqlSession sqlSession;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}