package com.wind.web;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.IDao;
import com.wind.web.dto.TicketDto;

@Controller
public class FController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/airport_list")
	public String airport_list(Model model) {
		System.out.println("airport_list");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("airport_list", dao.airport_listDao());
		return "/input/airport_list";
	}
	
	@RequestMapping("/airport_input")
	public String airport_input() { 
		System.out.println("airport_input");
//		IDao dao = sqlSession.getMapper(IDao.class);
		return "/input/airport_input";
	}

	@RequestMapping("inputAirport")
	public String inputAirtport(HttpServletRequest request) { 
		System.out.println("inputAirport");
		IDao dao = sqlSession.getMapper(IDao.class);
//		if(airportDao.aCodeCheck(request.getParameter("port_code"))) {
//			return "airport_code_error";
//		} else {
		dao.inputAirportDao(
					request.getParameter("port_continent"), 
					request.getParameter("port_country"), 
					request.getParameter("port_code"), 
					request.getParameter("port_name"));
			return "redirect:airport_list";
//		}
	}
	
	@RequestMapping("/airport_delete")
	public String airport_delete(HttpServletRequest request) { 
		System.out.println("/airport_delete");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.airport_deleteDao(request.getParameter("port_code"));
		return "redirect:airport_list";	
	}
	
//***********Ticket Table****************************	

	
	@RequestMapping("/ticket_list")
	public String ticket_list(Model model) { 
		System.out.println("ticket_list");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("ticket_list", dao.ticket_listDao());
		return "/input/ticket_list";
	}

	@RequestMapping("/ticket_input")
	public String ticket_input() { 
		System.out.println("ticket_input");
		return "/input/ticket_input";
	}
		
	@RequestMapping("/inputTicket")
	public String inputTicket(HttpServletRequest request) { 
		System.out.println("inputTicket");
		IDao dao = sqlSession.getMapper(IDao.class);
		String dname = dao.getPort_nameDao(request.getParameter("departure"));
		String aname = dao.getPort_nameDao(request.getParameter("arrive"));
		dao.inputTicketDao(
				request.getParameter("airline"),
				request.getParameter("flight_name"),
				request.getParameter("departure"),
				request.getParameter("arrive"),
				Timestamp.valueOf(request.getParameter("dep_time")),
				Timestamp.valueOf(request.getParameter("arri_time")),
				request.getParameter("seat_able"),
				request.getParameter("seat_price"),
				dname,
				aname
				);
		return "redirect:ticket_list";
	}

		
	@RequestMapping("ticket_delete")
	public String ticket_delete(HttpServletRequest request) {
		System.out.println("ticket_delete");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.ticket_deleteDao(request.getParameter("ticket_id"));
		return "redirect:ticket_list";
	}
	
	
	@RequestMapping("low_price")
	public String low_price(Model model) { 
		System.out.println("low_price");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("lowP", dao.low_priceDao());
		return "low_price";
	}
		
	@RequestMapping("continent_tickets")
	public String continent_tickets(HttpServletRequest request, Model model) { 
		System.out.println("continent_tickets");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("continent_tickets", dao.continent_ticketsDao(request.getParameter("continent")));
		return "continent_tickets";
	}
	
}
