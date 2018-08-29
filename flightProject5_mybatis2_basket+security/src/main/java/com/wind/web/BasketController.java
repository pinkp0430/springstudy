package com.wind.web;

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
		
		if(dao.basket_checkDao(String.valueOf(session.getAttribute("sess_id")), Integer.parseInt(request.getParameter("id"))) != null) {
			int getCnt = dao.basket_getCntDao(
					String.valueOf(session.getAttribute("sess_id")),
					Integer.parseInt(request.getParameter("id")));

				dao.basket_updateDao(
						String.valueOf(session.getAttribute("sess_id")),
						Integer.parseInt(request.getParameter("id")),
						Integer.parseInt(request.getParameter("count"))+ getCnt);
		} else {
			dao.basket_inputDao(
					String.valueOf(session.getAttribute("sess_id")),
					Integer.parseInt(request.getParameter("id")),
					Integer.parseInt(request.getParameter("count")));
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
	
	
}
