package com.wind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wind.web.service.*;

@Controller
public class BController {

	BService service = null;
	
	@RequestMapping("/list")
	public String list(Model model) { //주소창에 list가 끝으로 들어오면 이 메소드가 model과 함께 시작
		
		service = new BListService();
		service.execute(model);
		return "list"; // view/list.jsp가 호출이 된다.
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest httpServletRequest, Model model) {
		
		System.out.println("/content_view");
		model.addAttribute("request", httpServletRequest);
		service = new BContentService();
		service.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("/write_view");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("/write");
		model.addAttribute("request", request);
		service = new BWriteService();
		service.execute(model);
		return "redirect:list"; // list를 하게되면 걍 list.jsp를 부르고, 
								// redirect:list를 하게되면 저위의  @RequestMapping("/list")public String list()를 호출해 메소드를 실행.	
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("/delete");
		model.addAttribute("request", request);
		service = new BDeleteService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST) // get으로 보내면 안될 때, post 선언을 한다.
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("/modify");
		model.addAttribute("request", request);
		service = new BModifyService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply") // get
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("/reply");
		model.addAttribute("request", request);
		service = new BReplyService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view") // get
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("/reply_view");
		model.addAttribute("request", request);
		service = new BReplyViewService();
		service.execute(model);
		return "reply_view";
	}

}
