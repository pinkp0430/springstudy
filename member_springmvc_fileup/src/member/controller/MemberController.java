package member.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import member.dto.MemberDTO;
import member.model.service.MemberManageService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	private MemberManageService service;
	public MemberController(MemberManageService service){
		this.service = service;
	} 
	@RequestMapping("/registerMember.do")
	public ModelAndView registerMember(MemberDTO mto){
		ModelAndView mv = null;
		mto.setMileage(1000);
		try {
			service.registerMember(mto);
			mv = new ModelAndView("res/register_success","mdto", mto);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("res/error", "error_message", e.getMessage());
		}
		return mv;
	}
	
	@RequestMapping("/getAllMemberInfo.do")
	public ModelAndView getAllMemberList(){
		ModelAndView mv = null;
		try {
			List list = service.getMemberList();
			mv = new ModelAndView("res/member_list", "member_list", list);
		} catch (SQLException e) {
			e.printStackTrace();
			mv = new ModelAndView("res/error", "error_message", e.getMessage());
		}
		return mv;
	}
	@RequestMapping("/login.do")
	public ModelAndView login(String id, String password, HttpSession session){
		ModelAndView mv = null;
		try{
			MemberDTO mto = service.getMemberById(id);
			if(mto!=null){
				//패스 워드 비교
				if(password.equals(mto.getPassword())){//ID/Password 모두 맞는 경우
					session.setAttribute("login_info", mto);
					mv = new ModelAndView("res/login_success");
				}else{//패스워드가 틀린 경우
					mv = new ModelAndView("login_form", "error_message","패스워드가 틀렸습니다. 확인 후 다시 로그인 하세요.");
				}
			}else{//id가 없는 경우
				mv = new ModelAndView("login_form", "error_message",  id+"는 없는 ID입니다. 확인 후 다시 로그인 하세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mv = new ModelAndView("res/error", "error_message", e.getMessage());
		}
		return mv;
	}
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		ModelAndView mv = null;
		MemberDTO mdto = (MemberDTO)session.getAttribute("login_info");
		if(mdto==null){
			mv = new ModelAndView("login_form", "error_message", "로그인 후 로그아웃 할 수 있습니다. 로그아웃 먼저 하세요");
		}else{
			session.invalidate();
			mv = new ModelAndView("login_form");
		}
		return mv;
	}
	//로그인한 회원 정보 조회
	@RequestMapping("/getLoginMemberInfo.do")
	public ModelAndView getLoginMemberInfo(HttpSession session){
		ModelAndView mv = null;
		Object obj = session.getAttribute("login_info");
		if(obj==null){
			mv = new ModelAndView("login_form", "error_message", "로그인 후 회원정보 조회하십시요");
		}else{
			mv = new ModelAndView("res/member_detail");
		}
		return mv;
	}
	@RequestMapping("/modifyForm.do")
	public ModelAndView modifyForm(HttpSession session){
		ModelAndView mv = null;
		Object obj = session.getAttribute("login_info");
		if(obj==null){
			mv = new ModelAndView("login_form", "error_message", "로그인 후 회원정보 조회하십시요");
		}else{
			mv = new ModelAndView("res/modify_form");
		}
		return mv;
	}
	@RequestMapping("/modifyMember.do")
	public ModelAndView modifyMember(MemberDTO mto, HttpSession session){
		ModelAndView mv = null;
		MemberDTO loginInfo = (MemberDTO)session.getAttribute("login_info");
		if(loginInfo == null){//로그인 안된 경우
			mv = new ModelAndView("login_form", "error_message", "로그인 후 회원정보 수정이 가능합니다. 로그인 먼저 하세요");
		}else{
			//3. 회원 정보 수정 처리
			//1. 요청 파라미터 조회
			try {
				service.modifyMember(mto);
				mv = new ModelAndView("res/member_detail");
				loginInfo.setPassword(mto.getPassword());
				loginInfo.setName(mto.getName());
				loginInfo.setRegisterNumber1(mto.getRegisterNumber1());
				loginInfo.setRegisterNumber2(mto.getRegisterNumber2());
				if(mto.getUpfile()!=null&&!mto.getUpfile().isEmpty()){
					loginInfo.setPictureFilename(mto.getPictureFilename());
				}
			} catch (Exception e) {
				e.printStackTrace();
				mv = new ModelAndView("res/error", "error_message", e.getMessage());
			}
		}
		return mv;
	}
	
	@RequestMapping("/removeMember.do")
	public ModelAndView removeMember(HttpSession session)throws Exception{
		ModelAndView mv = null;
		MemberDTO loginInfo = (MemberDTO)session.getAttribute("login_info");
		if(loginInfo == null){//로그인 안된 경우
			mv = new ModelAndView("login_form", "error_message", "로그인 후 탈퇴가 가능합니다. 로그인 먼저 하세요");
		}else{
			try {
				service.removeMemberById(loginInfo);
				mv = new ModelAndView("login_form");
//				세션 소멸시키기
				session.invalidate();
			}catch (SQLException e) {
				e.printStackTrace();
				mv = new ModelAndView("res/error", "error_message", e.getMessage());
			} 
		}
		return mv;
	}
//	검색
	@RequestMapping("/searchMemberByMileageRange.do")
	public ModelAndView searchMemberByMileageRange(int sMileage, int eMileage){
		ModelAndView mv = null;
		try {
			List list = service.searchMemberByMileageRange(sMileage, eMileage);
			HashMap map = new HashMap();
			map.put("member_list", list);
			map.put("title", "마일리지 범위로 조회 결과");
			map.put("search_value", sMileage+"~"+eMileage);
			mv = new ModelAndView("res/search_result", map);
		} catch (SQLException e) {
			e.printStackTrace();
			mv = new ModelAndView("res/error", "error_message", e.getMessage());
		}
		return mv;
	}
	
	@RequestMapping("/searchMemberByName.do")
	public ModelAndView searchMemberByName(String name){
		ModelAndView mv = null;
		//1. 요청파라미터 조회
		//2. B.L 처리
		try{
			List list = service.searchMemberByName(name);
			HashMap map = new HashMap();
			map.put("member_list", list);
			
			map.put("title", "이름으로 검색");
			map.put("search_value", name);
			mv = new ModelAndView("res/search_result", map);			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			mv = new ModelAndView("res/error", "error_message", "이름으로 검색도중 오류발생");
		}	
		return mv;
	}
	//수정시 파일 삭제처리
	//modifyForm에서 파일 삭제 호출시 처리메소드
	@RequestMapping("/deleteFile.do")
	public ModelAndView deleteFile(HttpSession session)throws Exception{
		ModelAndView mv = null;
		MemberDTO loginInfo = (MemberDTO)session.getAttribute("login_info");
		if(loginInfo == null){//로그인 안된 경우
			mv = new ModelAndView("login_form", "error_message", "로그인 후 사진 삭제가 가능합니다. 로그인 먼저 하세요");
		}else{
			//DB에서 사진 정보 삭제
			service.deleteFile(loginInfo);
			mv = new ModelAndView("res/modify_form");
		}
		return mv;
	}
}














































