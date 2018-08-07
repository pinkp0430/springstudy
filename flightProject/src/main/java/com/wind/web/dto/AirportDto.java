package com.wind.web.dto;

public class AirportDto {
	
	private String port_continent; 
	private String port_country;
	private String port_code; 
	private String port_name;
	
	public AirportDto() { }

	public AirportDto(String port_continent, String port_country, String port_code, String port_name) {
		super();
		this.port_continent = port_continent;
		this.port_country = port_country;
		this.port_code = port_code;
		this.port_name = port_name;
	}

	public String getPort_continent() {
		return port_continent;
	}

	public void setPort_continent(String port_continent) {
		this.port_continent = port_continent;
	}

	public String getPort_country() {
		return port_country;
	}

	public void setPort_country(String port_country) {
		this.port_country = port_country;
	}

	public String getPort_code() {
		return port_code;
	}

	public void setPort_code(String port_code) {
		this.port_code = port_code;
	}

	public String getPort_name() {
		return port_name;
	}

	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}



}
