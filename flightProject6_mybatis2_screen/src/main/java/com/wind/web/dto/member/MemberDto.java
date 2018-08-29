package com.wind.web.dto.member;

public class MemberDto {

	String username;
	String password;
	String m_name;
	String m_call;
	
	public MemberDto() {}

	public MemberDto(String username, String password, String m_name, String m_call) {
		super();
		this.username = username;
		this.password = password;
		this.m_name = m_name;
		this.m_call = m_call;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_call() {
		return m_call;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_call(String m_call) {
		this.m_call = m_call;
	}
	
	
	
	
	
}
