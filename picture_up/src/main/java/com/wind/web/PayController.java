package com.wind.web;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.PayDao;
import com.wind.web.dao.SearchDao;

@Controller
public class PayController {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 결제 확인 페이지
	@RequestMapping("pay_check")
	public String pay_check(HttpServletRequest request, Model model) { 
		System.out.println("pay_check"+ 5*4);
		SearchDao dao = sqlSession.getMapper(SearchDao.class);
		model.addAttribute("count", request.getParameter("count"));
		model.addAttribute("pay_check", dao.ticket_portDao(Integer.parseInt(request.getParameter("id"))));
		return "/search/pay_check";
	}
	
	
	// 구매완료되면 티켓 지우기 + payTB에 결제 내용 넣기
	@RequestMapping("pay_confirm")
	public String pay_confirm(HttpServletRequest request, Model model) { 
		System.out.println("pay_confirm");
		PayDao dao = sqlSession.getMapper(PayDao.class);
		model.addAttribute("pay_list", dao.pay_listDao(				
											request.getParameter("flight_code"),
											request.getParameter("arrive"),
											Timestamp.valueOf(request.getParameter("dep_time")),
											request.getParameter("count")));
		
		dao.pay_confirmDao(
				request.getParameter("flight_code"),
				request.getParameter("arrive"),
				Timestamp.valueOf(request.getParameter("dep_time")),
				request.getParameter("count"));
		
		return "redirect:index_search";
	}
	


	
}
