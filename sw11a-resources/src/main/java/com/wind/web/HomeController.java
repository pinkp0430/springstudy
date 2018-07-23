package com.wind.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/board/view")
	public ModelAndView view1() {		// Model이라는 객체가 이미 잇음. 가져다 쓰면됨 (Model model)
//		model.addAttribute("id",20);
//		model.addAttribute("name","ABC");
//		System.out.println(model);
//		return "/board/view";
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",20);
		mv.addObject("name","ABC");
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value = "/board/content")
	public ModelAndView content() {
//		model.addAttribute("id",3);
//		model.addAttribute("name","푸하하");
//		return "/board/content";
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",3);
		mv.addObject("name","푸하하");
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value = "/board/reply")
	public ModelAndView reply() {
//		model.addAttribute("id",5);
//		model.addAttribute("name","음화화");
//		return "/board/reply";
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",15);
		mv.addObject("name","음화화");
		mv.setViewName("board/reply");
		return mv;
	}
	
}
