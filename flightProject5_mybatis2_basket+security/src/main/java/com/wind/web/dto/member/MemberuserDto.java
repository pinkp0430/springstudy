package com.wind.web.dto.member;

public class MemberuserDto {
	
	String username;
	String password;
	
	public MemberuserDto() {}

	public MemberuserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
