package com.wind.web.dto;

import java.sql.Timestamp;

public class LowPriceContinentDto {
	
	 private String continent;
	 private int price;	
	 private String code;
	 private String name;
	 private Timestamp dep_time;
	
	 public LowPriceContinentDto() {
		super();
	  }

	public LowPriceContinentDto(String continent, int price, String code, String name, Timestamp dep_time) {
		super();
		this.continent = continent;
		this.price = price;
		this.code = code;
		this.name = name;
		this.dep_time = dep_time;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Timestamp getDep_time() {
		return dep_time;
	}

	public void setDep_time(Timestamp dep_time) {
		this.dep_time = dep_time;
	}

	
}
