package com.wind.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wind.web.dao.BasketDao;
import com.wind.web.dao.member.MDao;
import com.wind.web.dao.member.MUserDao;
import com.wind.web.dto.member.MemberDto;

@Controller
public class LoginController {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "notice/home";
	}
	
	@RequestMapping("/login.html")
	public String login(HttpSession session) {
		System.out.println("login");
		if(session.getAttribute("sess_id") != null) {
			BasketDao dao = sqlSession.getMapper(BasketDao.class);
			dao.username_updateDao(String.valueOf(session.getAttribute("sess_id")), currentUserName());
		} else {
			session.setAttribute("sess_id", currentUserName());
		}
		
		return "security/login";
	}
	
	@RequestMapping("/index_input.html")
	public String welcome() {
		return "index_input";
	}
	
	@RequestMapping("/loginForm.html")
	public String loginForm() {
		return "security/loginForm";
	}
	
	@RequestMapping("/write_m")//가입입력사항
	public String write_m() { 
		return "security/write_m";
	}

	@RequestMapping("/write_m_view")//가입입력사항 다오에 적용,mapper타고 sql입력
	public String write(HttpServletRequest request, Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		//**기존에 아이디가 있으면 가입불가 처리하기
		MemberDto dto = dao.viewDao(request.getParameter("username"));
		if (dto != null) {
			return "security/error";
		} else {
			dao.writeDao(
					request.getParameter("username"), 
					request.getParameter("password"), 
					request.getParameter("m_name"), 
					request.getParameter("m_call"));
			MemberDto mdto = dao.viewDao(request.getParameter("username"));//파람을 이엘테그로 사용하기 위해 씀
			model.addAttribute("mdto", mdto);
			return "security/write_m_view";
		}
	}


	@RequestMapping("/write_c")//write_m_view에서 가입하기:username과 password 받아서 memberuser테이블에 입력하고, 가입완료 화면으로 넘기기
	public String write_c(HttpServletRequest request, Model model) {
		//member에서 username, password찾기
		MDao dao = sqlSession.getMapper(MDao.class);
		MemberDto mdto = dao.viewDao(request.getParameter("username"));
		
		//member에서 찾은 username, password를 MemberDto매개로 사용
		MUserDao udao = sqlSession.getMapper(MUserDao.class);
		udao.writeUDao(mdto.getUsername(), mdto.getPassword());
		return "security/write_c";
	}

	@RequestMapping("/delete")//write_m_view에서 취소하기: member데이터 도로 지우기
	public String delete(HttpServletRequest request, Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		dao.deleteDao(request.getParameter("username"));
		return "security/write_del";
	}
	
	// 현재 로그인 상태의  username을 알아오는 메소드
	public static String currentUserName() { 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		return authentication.getName(); 
	}
	
	
	
// ************** 안쓰는 것들 *********************	
	@RequestMapping("/notice/home")
	public String notice_home() {
		return "notice/home";
	}
}
