package com.wind.web.dto;

public class MajorDto {
	
	private String id;
	private String m_name;
	
	public MajorDto() {
		super();
	}

	public MajorDto(String id, String m_name) {
		super();
		this.id = id;
		this.m_name = m_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	
	

}
