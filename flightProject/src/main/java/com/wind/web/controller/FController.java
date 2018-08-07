package com.wind.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.AirportDao;
import com.wind.web.dao.TicketDao;
import com.wind.web.dto.AirportDto;
import com.wind.web.dto.TicketDto;


@Controller
public class FController {
	
	AirportDao airportDao;
	TicketDao ticketDao;

//***********Airport Table*******************************
	
	@Autowired
	public void setAirportDao(AirportDao airportDao) {
		this.airportDao = airportDao;
	}
	
	@RequestMapping("/index")
	public String index() { System.out.println("index");
		return "index";
	}
	
	@RequestMapping("/airport_input")
	public String airport_input() { System.out.println("airport_input");
		return "/input/airport_input";
	}
	
	@RequestMapping("inputAirport")
	public String inputAirtport(HttpServletRequest request) { System.out.println("inputAirport");
//		if(airportDao.aCodeCheck(request.getParameter("port_code"))) {
//			return "airport_code_error";
//		} else {
			airportDao.inputAirport(
					request.getParameter("port_continent"), 
					request.getParameter("port_country"), 
					request.getParameter("port_code"), 
					request.getParameter("port_name"));
			return "redirect:airport_list";
//		}
	}
	
	@RequestMapping("/airport_list")
	public String list(Model model) { System.out.println("/airport_list");
		ArrayList<AirportDto> airportDtos = airportDao.list();
		model.addAttribute("airport_list", airportDtos);
		return "/input/airport_list";
	}
	
	@RequestMapping("/airport_delete")
	public String airport_delete(HttpServletRequest request) { System.out.println("/airport_delete");
		airportDao.delete(request.getParameter("port_code"));
		return "redirect:airport_list";	
	}
	
//***********Ticket Table****************************	

	
	@Autowired
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	@RequestMapping("/ticket_input")
	public String ticket_input() { System.out.println("ticket_input");
		return "/input/ticket_input";
	}
	
	@RequestMapping("/inputTicket")
	public String inputTicket(HttpServletRequest request) { System.out.println("inputTicket");
		System.out.println(request.getParameter("dtime"));
		ticketDao.inputTicket(
				request.getParameter("airline"),
				request.getParameter("flight_name"),
				request.getParameter("departure"),
				request.getParameter("arrive"),
				Timestamp.valueOf(request.getParameter("dep_time")),
				Timestamp.valueOf(request.getParameter("arri_time")),
				request.getParameter("seat_able"),
				request.getParameter("seat_price")
//				Timestamp.valueOf(request.getParameter("dtime")),
//				request.getParameter("stime")
				);
		return "redirect:ticket_list";
	}
	
	@RequestMapping("/ticket_list")
	public String ticket_list(Model model) { System.out.println("ticket_list");
		ArrayList<TicketDto> ticketDtos = ticketDao.list();
		model.addAttribute("ticket_list", ticketDtos);
		return "/input/ticket_list";
	}
	
	@RequestMapping("ticket_delete")
	public String ticket_delete(HttpServletRequest request) {System.out.println("ticket_delete");
		ticketDao.delete(request.getParameter("ticket_id"));
		return "redirect:ticket_list";
	}
	
	@RequestMapping("low_price")
	public String low_price(Model model) { System.out.println("low_price");
		TicketDto tDto = ticketDao.low_price();
		model.addAttribute("lowP", tDto);
		return "low_price";
	}
	
	@RequestMapping("continent_tickets")
	public String continent_tickets(HttpServletRequest request, Model model) { System.out.println("continent_tickets");
		ArrayList<TicketDto> ticketDtos = ticketDao.continent_tickets(request.getParameter("continent"));
		model.addAttribute("continent_tickets", ticketDtos);
		return "continent_tickets";
	}
	
}
