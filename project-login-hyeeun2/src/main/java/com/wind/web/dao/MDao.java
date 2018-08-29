package com.wind.web.dao;
import java.util.ArrayList;

import com.wind.web.dto.MemberDto;



public interface MDao {

	public ArrayList<MemberDto> listDao();
	public void writeDao(String username, String password, String m_name, String m_call);
	public MemberDto viewDao(String username);
	public void deleteDao(String username);
	
}
