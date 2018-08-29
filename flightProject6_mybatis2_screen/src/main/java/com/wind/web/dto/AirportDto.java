package com.wind.web.dto;

public class AirportDto {
	
	private String ap_code; 
	private String ap_name;
	private String country_code;
	
	public AirportDto() { }

	public AirportDto(String ap_code, String ap_name, String country_code) {
		super();
		this.ap_code = ap_code;
		this.ap_name = ap_name;
		this.country_code = country_code;
	}

	public String getAp_code() {
		return ap_code;
	}

	public void setAp_code(String ap_code) {
		this.ap_code = ap_code;
	}

	public String getAp_name() {
		return ap_name;
	}

	public void setAp_name(String ap_name) {
		this.ap_name = ap_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	
}
