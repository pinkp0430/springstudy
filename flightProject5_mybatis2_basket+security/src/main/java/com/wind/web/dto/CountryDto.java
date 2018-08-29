package com.wind.web.dto;

public class CountryDto {
	
	private String c_code;
	private String c_name;
	private String continent;
	
	public CountryDto() {
		super();
	}

	public CountryDto(String c_code, String c_name, String continent) {
		super();
		this.c_code = c_code;
		this.c_name = c_name;
		this.continent = continent;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	
}
