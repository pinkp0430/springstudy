package com.wind.web.dto;

public class CountryDto {
	
	private String code;
	private String name;
	private String continent;
	
	public CountryDto() {
		super();
	}

	public CountryDto(String code, String name, String continent) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
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

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	

}
