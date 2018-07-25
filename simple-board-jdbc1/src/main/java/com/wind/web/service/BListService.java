package com.wind.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.wind.web.dao.BDao;
import com.wind.web.dto.BDto;
import com.wind.web.util.Constant;

public class BListService implements BService {

	private JdbcTemplate template;
	
	@Autowired  //기본 셋을 하란 야그.. servlet-context.xml에서 bean 두개로 DB 연결해 오는 셋팅을 해놧기 때문에 이걸 쓸 수 있다.
	public void setTemplate(JdbcTemplate template) {
		this.template = template; //private 셋으로 함 감춰주고?? 
		Constant.template = this.template; // static한 Constant.template에 다시 넣어준다.
	}
	
	@Override
	public void execute(Model model) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos); //dtos가 list라는 이름으로 model에 셋

	}

}
