package com.wind.web.dto;

public class AirportDto {
	
	private String code; 
	private String name;
	private String country_code;
	
	public AirportDto() { }

	public AirportDto(String code, String name, String country_code) {
		super();
		this.code = code;
		this.name = name;
		this.country_code = country_code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	
}
