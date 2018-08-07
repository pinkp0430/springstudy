package com.wind.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.IDao;
import com.wind.web.dao.SpecialtiesDao;
import com.wind.web.dao.VetsDao;
import com.wind.web.dto.VetsDto;
import com.wind.web.dto.VetspecialtiesDto;

@Controller
public class VetsController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/vetslist")
	public String vetslist(Model model) {
		VetsDao dao = sqlSession.getMapper(VetsDao.class);
		model.addAttribute("vetslist", dao.vetslistDao());
		return "vetslist";
	}
	
	@RequestMapping("/vetselect_view")
	public String vetselect_view(Model model) {
		SpecialtiesDao dao = sqlSession.getMapper(SpecialtiesDao.class);
		model.addAttribute("vetselect_view", dao.vetselect_viewDao());
		return "vetselect_view";
	}
	
	@RequestMapping("/vetselect")
	public String vetselect(HttpServletRequest request, Model model) {
		VetsDao dao = sqlSession.getMapper(VetsDao.class);
//		model.addAttribute("vetselect", dao.vetselectDao
//				(Integer.parseInt(request.getParameter("specialty_id"))));
		
		ArrayList<VetspecialtiesDto> dto; // dto....{4,5,8}..dto.get(0)
		dto = dao.vetselectDao(Integer.parseInt(request.getParameter("specialty_id")));
		
		ArrayList<VetsDto> dto2 = new ArrayList<VetsDto>();
		for(int i=0; i<dto.size(); i++) {
			dto2.add(dao.vetselect2Dao(dto.get(i).getVet_id()));
		}
		
		model.addAttribute("vetselect", dto2);
		return "vetselect";
	}
	
	@RequestMapping("/vetselect3")
	public String vetselect3(HttpServletRequest request, Model model) {
		VetsDao dao = sqlSession.getMapper(VetsDao.class);
		model.addAttribute("vetselect", dao.vetselect3Dao(Integer.parseInt(request.getParameter("specialty_id"))));
		return "vetselect";
	}
	
	@RequestMapping("/vet_add_view")
	public String vet_add_view() {
		return "vet_add_view";
	}
	
	@RequestMapping("/vet_add")
	public String vet_add(HttpServletRequest request, Model model) {
		VetsDao dao = sqlSession.getMapper(VetsDao.class);
		dao.vet_addDao(request.getParameter("first_name"),request.getParameter("last_name"));
		return "redirect:vetslist";
	}	
	
	@RequestMapping("/vet_spe_add_view") // 의사리스트를 뿌려주면서 전공을 받아오는 페이지
	public String vet_spe_add_view(Model model) {
		VetsDao dao = sqlSession.getMapper(VetsDao.class);
		model.addAttribute("vetslist", dao.vetslistDao());		
		return "/add/vet_spe_add_view";
	}
	
	@RequestMapping("/vet_specialties_add")
	public String vet_specialties_add(HttpServletRequest request) {
		VetsDao dao = sqlSession.getMapper(VetsDao.class);
		dao.vet_deleteDao(request.getParameter("vet_id"));
		String[] sps = request.getParameterValues("specialties");
		for(int i=0; i<sps.length; i++) {
			dao.vet_specialties_addDao(request.getParameter("vet_id"), sps[i]);
		}
		return "redirect:vet_spe_add_view";
	}
	
	
	
	
	
	
	@ExceptionHandler
	public String handlerException(Exception e) {
		return "viewerror";
	}

	
}
