package com.wind.web;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.AirlineDao;
import com.wind.web.dao.AirportDao;
import com.wind.web.dao.CountryDao;
import com.wind.web.dao.TicketDao;

@Controller
public class InputController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/index_input")
	public String index_input() {
		return "index_input";
	}

//***********Airport Table****************************	

	@RequestMapping("/airport_list") 
	public String airport_list(Model model) {
		System.out.println("airport_list");
		AirportDao dao = sqlSession.getMapper(AirportDao.class);
		model.addAttribute("airport_list", dao.airport_listDao());
		return "/input/airport_list";
	}
	
	@RequestMapping("/airport_input")
	public String airport_input() { 
		System.out.println("airport_input");
		return "/input/airport_input";
	}

	@RequestMapping("inputAirport")
	public String inputAirtport(HttpServletRequest request) { 
		System.out.println("inputAirport");
		AirportDao dao = sqlSession.getMapper(AirportDao.class);
//		if(airportDao.aCodeCheck(request.getParameter("port_code"))) {
//			return "airport_code_error";
//		} else {
		dao.inputAirportDao(
					request.getParameter("ap_code"), 
					request.getParameter("ap_name"),
					request.getParameter("country_code"));
			return "redirect:airport_list";
//		}
	}
	
	@RequestMapping("/airport_delete")
	public String airport_delete(HttpServletRequest request) { 
		System.out.println("/airport_delete");
		AirportDao dao = sqlSession.getMapper(AirportDao.class);
		dao.airport_deleteDao(request.getParameter("ap_code"));
		return "redirect:airport_list";	
	}

//***********Country Table****************************	

	@RequestMapping("/country_list") 
	public String country_list(Model model) {
		System.out.println("country_list");
		CountryDao dao = sqlSession.getMapper(CountryDao.class);
		model.addAttribute("country_list", dao.country_listDao());
		return "/input/country_list";
	}
		
	@RequestMapping("/country_input")
	public String country_input() { 
		System.out.println("country_input");
		return "/input/country_input";
	}

	@RequestMapping("inputCountry")
	public String inputCountry(HttpServletRequest request) { 
		System.out.println("inputCountry");
		CountryDao dao = sqlSession.getMapper(CountryDao.class);
		dao.inputCountryDao(
			request.getParameter("c_code"), 
			request.getParameter("c_name"),
			request.getParameter("continent"));
		return "redirect:country_list";
	}
		
	@RequestMapping("/country_delete")
	public String country_delete(HttpServletRequest request) { 
		System.out.println("/country_delete");
		CountryDao dao = sqlSession.getMapper(CountryDao.class);
		dao.country_deleteDao(request.getParameter("c_code"));
		return "redirect:country_list";	
	}

		
//***********Airline Table****************************	

	@RequestMapping("/airline_list") 
	public String airline_list(Model model) {
		System.out.println("airline_list");
		AirlineDao dao = sqlSession.getMapper(AirlineDao.class);
		model.addAttribute("airline_list", dao.airline_listDao());
		return "/input/airline_list";
	}
		
	@RequestMapping("/airline_input")
	public String airline_input() { 
		System.out.println("airline_input");
		return "/input/airline_input";
	}

	@RequestMapping("inputAirline")
	public String inputAirline(HttpServletRequest request) { 
		System.out.println("inputAirline");
		AirlineDao dao = sqlSession.getMapper(AirlineDao.class);
		dao.inputAirlineDao(
			request.getParameter("a_code"), 
			request.getParameter("a_name")
		);
		return "redirect:airline_list";
	}
		
	@RequestMapping("/airline_delete")
	public String airline_delete(HttpServletRequest request) { 
		System.out.println("/airline_delete");
		AirlineDao dao = sqlSession.getMapper(AirlineDao.class);
		dao.airline_deleteDao(request.getParameter("a_code"));
		return "redirect:airline_list";	
	}
	
	
//***********Ticket Table****************************	
		
	@RequestMapping("/ticket_list")
	public String ticket_list(Model model) { 
		System.out.println("ticket_list");
		TicketDao dao = sqlSession.getMapper(TicketDao.class);
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
		TicketDao dao = sqlSession.getMapper(TicketDao.class);
		dao.inputTicketDao(
			request.getParameter("flight_code"),
			request.getParameter("departure"),
			request.getParameter("arrive"),
			Timestamp.valueOf(request.getParameter("dep_time")),
			Timestamp.valueOf(request.getParameter("flight_time")),
			Timestamp.valueOf(request.getParameter("arri_time")),
			Integer.parseInt(request.getParameter("price")),
			request.getParameter("md")
		);
		return "redirect:ticket_list";
	}

	@RequestMapping("ticket_delete")
	public String ticket_delete(HttpServletRequest request) {
		System.out.println("ticket_delete");
		TicketDao dao = sqlSession.getMapper(TicketDao.class);
		dao.ticket_deleteDao(request.getParameter("ticket_id"));
		return "redirect:ticket_list";
	}
		
}
