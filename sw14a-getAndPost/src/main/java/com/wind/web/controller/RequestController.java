package com.wind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {

	@RequestMapping("/index") 
	public String goIndex() {
		return "index";
	}

//	@RequestMapping("/student")// GET방식으로 기본 셋팅, 주소창에 id & pw 값이 다 나옴
//	@RequestMapping(value="/student", method=RequestMethod.GET)// GET방식
//	@RequestMapping(value="/student", method=RequestMethod.POST)// POST방식으로 받는다고 셋팅, Post방식으로 보내는 곳도 셋팅하라 
//	@RequestMapping(value="/student", method= {RequestMethod.GET, RequestMethod.POST}) //GET&POST 다됨
	@RequestMapping(value="/student") //GET&POST 다됨
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("studentId",id);
		model.addAttribute("studentPw",pw);
		
		return "student";
	}
}
