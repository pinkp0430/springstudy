package com.wind.web.dto;

public class EngineerDto {

	private String id;
	private String e_name;
	private String phone;
	private String salary;
	
	public EngineerDto() {
		super();
	}

	public EngineerDto(String id, String e_name, String phone, String salary) {
		super();
		this.id = id;
		this.e_name = e_name;
		this.phone = phone;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	
}
