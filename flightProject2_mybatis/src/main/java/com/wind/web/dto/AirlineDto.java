package com.wind.web.dto;

public class AirlineDto {
	
	private String a_code;
	private String a_name;

	public AirlineDto() {
		super();
	}

	public AirlineDto(String a_code, String a_name) {
		super();
		this.a_code = a_code;
		this.a_name = a_name;
	}

	public String getA_code() {
		return a_code;
	}

	public void setA_code(String a_code) {
		this.a_code = a_code;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	
	
}
