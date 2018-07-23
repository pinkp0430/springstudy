package com.wind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HttpRequestController {

	// STEP 1
	@RequestMapping("board/confirm_id")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		// /board/confirm_id?id=pppp&pw=12345
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "board/confirm_id";
	}

	// STEP 2
	@RequestMapping("board/check_id")
	public String checkId(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw, Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "board/check_id";
	}
	
	// STEP 3
//	@RequestMapping("member/join")
//	public String joinData(
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw, 
//			@RequestParam("name") String name,
//			@RequestParam("email") String email, Model model) {
//		
//		Member member = new Member();
//		
//		member.setId(id);
//		member.setPw(pw);
//		member.setName(name);
//		member.setEmail(email);
//		
//		model.addAttribute("member",member);
//		
//		return "member/join";
//	}
	
	// STEP 4
	// 와우!!! STEP3에서는 일일이 set을 해주엇으나.. 스프링은 이걸 해준다~~. 클래스 Member를 보고, 필드를 보고, 파람을 받아 알아서 넣을 생각을 하다니.. 대박!!!! 
	@RequestMapping("member/joinsimple")
	public String joinDataSimple(@ModelAttribute("mem") Member member) {
		
		return "member/join";
	}
	
	// STEP 5
	// 주소창에 ?을 이용해 파람을 넣는 게 아니라, member/pinkp라고 바로 넣는다. (=?id=pinkp)
	@RequestMapping("member/{memberId}")
	public String getMemberId(
			@PathVariable String memberId,
			Model model) {
		
		model.addAttribute("memberId", memberId);
		return "member/memberView";
	}
	
}
