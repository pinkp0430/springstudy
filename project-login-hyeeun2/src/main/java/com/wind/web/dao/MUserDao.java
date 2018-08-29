package com.wind.web.dao;
import java.util.ArrayList;

import com.wind.web.dto.MemberuserDto;





public interface MUserDao {

	public ArrayList<MemberuserDto> listUDao();
	public void writeUDao(String username, String password);
	public MemberuserDto viewUDao(String username);
	public void deleteUDao(String username);
	
}
