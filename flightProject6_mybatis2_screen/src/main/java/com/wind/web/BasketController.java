package com.wind.web;

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
public class BasketController {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 장바구니에 넣기
	@RequestMapping("basket_input")
	public String basket(HttpSession session, HttpServletRequest request) { 
		System.out.println("basket_input");
		BasketDao dao = sqlSession.getMapper(BasketDao.class);
		System.out.println(session.getAttribute("sess_id"));

		if( session.getAttribute("sess_id") == null) {
			session.setAttribute("sess_id", session.getId());
		} 
		
		String username = String.valueOf(session.getAttribute("sess_id"));
		
		int ticket_id = Integer.parseInt(request.getParameter("id"));
		int count = Integer.parseInt(request.getParameter("count"));
		int ableCnt = dao.getableCntDao(ticket_id);  // 잔여석을 가져와서
		
		System.out.println("잔여석" + ableCnt);	
		
		// sess_id와 티켓id가 장바구니에 존재하면 
		if(dao.basket_checkDao(username, ticket_id) != null) {
			// sess_id가 이미 장바구니에 넣은 티켓id의 매수를 가져와
			System.out.println(count );
			int getCnt = dao.basket_getCntDao(username,	ticket_id);
			System.out.println(getCnt );

			
			if ((count + getCnt) <= ableCnt) { // 매수가 잔여석보다 작은지 체크
				dao.basket_updateDao(username, ticket_id, count + getCnt);  // count + getCnt 한 값을 넣는다.
			} else {
				return("security/error_able");
						
			}
		// sess_id와 티켓id가 장바구니에 존재하지 않으면
		} else {
			if (count <= ableCnt) { // 매수가 잔여석보다 작은지 체크
				dao.basket_inputDao(username, ticket_id, count);
			} else {
				return("security/error_able");
			}
		}
		System.out.println("basket_input_end");		
		return "redirect:basket_list";
	}

	@RequestMapping("basket_list")
	public String basket_list(HttpSession session, Model model) {

		System.out.println("basket_list");
		BasketDao dao = sqlSession.getMapper(BasketDao.class);
		System.out.println(session.getAttribute("sess_id"));		
		model.addAttribute("basket_list", dao.basket_listDao(String.valueOf(session.getAttribute("sess_id"))));
		System.out.println("basket_list_end");
		return "/basket/basket_list";
	}
	
	@RequestMapping("basket_delete")
	public String basket_delete(HttpSession session, HttpServletRequest request, Model model) { 
		System.out.println("basket_delete");
		BasketDao dao = sqlSession.getMapper(BasketDao.class);
		System.out.println(session.getAttribute("sess_id"));		
		dao.basket_deleteDao(
				String.valueOf(session.getAttribute("sess_id")),
				Integer.parseInt(request.getParameter("id")));
		return "/basket/basket_list";
	}
	
//	@RequestMapping("basket_login_check")
//	public String basket_login_check(HttpSession session, HttpServletRequest request, Model model) { 
//		System.out.println("basket_login_check");
//		System.out.println(session.getAttribute("sess_id"));
//		BasketDao dao = sqlSession.getMapper(BasketDao.class);
//		if (session.getAttribute("sess_id") == "anonymousUser") {
//			return "/security/loginForm";
//		} else {
//			return "pay_confirm";
//		}
//	}


	
}
