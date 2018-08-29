package com.wind.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.BasketDao;
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
		return "/pay/pay_check";
	}
	
	
	// 구매완료되면 장바구니에서 구매체크 + 티켓 잔여석 마이너스  + payTB에 결제 내용 넣기
	@RequestMapping("pay_confirm")
	public String pay_confirm(HttpSession session, HttpServletRequest request, Model model) { 
		System.out.println("pay_confirm");
		PayDao pDao = sqlSession.getMapper(PayDao.class);
		BasketDao bDao = sqlSession.getMapper(BasketDao.class);
		
		String username = String.valueOf(session.getAttribute("sess_id"));
		int ticket_id = Integer.parseInt(request.getParameter("id"));
		int count = Integer.parseInt(request.getParameter("count"));
		int total = Integer.parseInt(request.getParameter("price"))*count;
		bDao.paidUpdateDao(username, ticket_id); // 장바구니에서 username + ticket_id를 찾아 구매되엇다는 validity=0 을 처리
		
		pDao.pay_confirmDao(count, ticket_id); // 티켓테이블에서 잔여석 마이너스

		Date date = new Date();
		
	    System.out.println(date);
	    
		pDao.paidInfo_inputDao(username, total, date);
		int pay_id = pDao.getPay_idDao(username);
		pDao.paidList_inputDao(pay_id, ticket_id, count);
		return "redirect:index_search";
	}
	


	
}
