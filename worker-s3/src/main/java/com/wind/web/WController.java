package com.wind.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.dao.IDao;
import com.wind.web.dto.EngineerDto;
import com.wind.web.dto.EngineerMajorDto;


@Controller
public class WController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/majorlist")
	public String majorlist(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("majorlist", dao.majorlistDao());
		return "majorlist";
	}
	
	@RequestMapping("/majorselect_view")
	public String majorselect_view(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("majorselect_view", dao.majorselect_viewDao());
		return "majorselect_view";
	}
	
	@RequestMapping("/majorselect")
	public String majorselect(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
//		model.addAttribute("majorselect", dao.majorselectDao
//				(Integer.parseInt(request.getParameter("specialty_id"))));
		
		ArrayList<EngineerMajorDto> dto; // dto....{4,5,8}..dto.get(0)
		dto = dao.majorselectDao(Integer.parseInt(request.getParameter("major_id"))); // 
		ArrayList<EngineerDto> dto2 = new ArrayList<EngineerDto>();
		for(int i=0; i<dto.size(); i++) {
			dto2.add(dao.majorselect2Dao(dto.get(i).getEng_id()));
		}
		
		model.addAttribute("majorselect", dto2);
		return "majorselect";
	}
	
	@RequestMapping("/majorselect3")
	public String majorselect3(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("majorselect", dao.majorselect3Dao(Integer.parseInt(request.getParameter("major_id"))));
		return "majorselect";
	}


}
