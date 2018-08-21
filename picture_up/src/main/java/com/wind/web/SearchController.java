package com.wind.web;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.AirportDao;
import com.wind.web.dao.CountryDao;
import com.wind.web.dao.SearchDao;
import com.wind.web.dao.TicketDao;
import com.wind.web.dto.TicketDto;

@Controller
public class SearchController {
	
	@Autowired
	private SqlSession sqlSession;

	//최저값 첫 페이지
	@RequestMapping("index_search")
	public String index_search(Model model) { 

		//최저가 리스트를 얻자
		SearchDao dao1 = sqlSession.getMapper(SearchDao.class);	
		//공항 6개를 정해 4개씩 리스트 생성
		model.addAttribute("low_price_list", dao1.low_price_listDao("가와"));
		model.addAttribute("low_price_list2", dao1.low_price_listDao("미국공항"));
		model.addAttribute("low_price_list3", dao1.low_price_listDao("케냐공항"));
		model.addAttribute("low_price_list4", dao1.low_price_listDao("뉴질랜드공항"));
		model.addAttribute("low_price_list5", dao1.low_price_listDao("이태리공항"));
		model.addAttribute("low_price_list6", dao1.low_price_listDao("브라질공항"));
		
		// 대륙별, 나라별 선택하기위한 그룹이름
		CountryDao dao3 = sqlSession.getMapper(CountryDao.class);	
		model.addAttribute("continent_list", dao3.continent_listDao());
		model.addAttribute("country_list", dao3.country_listDao());
		return "index_search";
	}
	
	// 하나의 티켓보여주기 + 카운트
	@RequestMapping("ticket_port")
	public String ticket_port(HttpServletRequest request, Model model) { 
		System.out.println("ticket_port");
		SearchDao dao = sqlSession.getMapper(SearchDao.class);
		model.addAttribute("ticket_port", dao.ticket_portDao(Integer.parseInt(request.getParameter("id"))));
		model.addAttribute("count", dao.countDao(
										request.getParameter("flight_code"),
										request.getParameter("arrive"),
										Timestamp.valueOf(request.getParameter("dep_time"))));
		return "/search/ticket_port";
	}
	
	
	
//******************** 안쓰는 것들
	// [arrive]를 받아, 가격순으로 리스트를 보여주기
	@RequestMapping("ticket_port_list")
	public String ticket_port_list(HttpServletRequest request, Model model) { 
		System.out.println("ticket_port_list");
		SearchDao dao = sqlSession.getMapper(SearchDao.class);
		model.addAttribute("ticket_port_list", dao.ticket_port_listDao(request.getParameter("arrive")));
		return "/search/ticket_port_list";
	}
	
	// [continent]를 받아 대륙별 리스트 만들기
	@RequestMapping("continent_tickets")
	public String continent_tickets(HttpServletRequest request, Model model) { 
		System.out.println(request.getParameter("continent"));
		SearchDao dao = sqlSession.getMapper(SearchDao.class);
		model.addAttribute("continent_tickets", dao.continent_ticketsDao(request.getParameter("continent")));
		return "/search/continent_tickets";
	}
	
	// 모든 티켓 중 최저가 한개
	@RequestMapping("low_price")
	public String low_price(Model model) { 
		System.out.println("low_price");
		SearchDao dao = sqlSession.getMapper(SearchDao.class);
		model.addAttribute("low_price", dao.low_priceDao());
		return "/search/low_price";
	}
	
}
