package com.wind.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.MDao;
import com.wind.web.dto.MDto;

@Controller
public class MController {

	MDao dao;
	
	@Autowired
	public void setDao(MDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/list")
	public String list(Model model) { System.out.println("/list");
		ArrayList<MDto> dtos = dao.list();
		model.addAttribute("list",dtos);
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) { System.out.println("/view");
		MDto dto = dao.view(request.getParameter("id"));
		model.addAttribute("view", dto);
		return "view";
	}
	
	@RequestMapping("/write_view")
	public String wirite_view() {System.out.println("/write_view");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {System.out.println("/write");
		dao.write(request.getParameter("name"), request.getParameter("title"), request.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {System.out.println("/delete");
		dao.delete(request.getParameter("id"));
		return "redirect:list";
	}
}
