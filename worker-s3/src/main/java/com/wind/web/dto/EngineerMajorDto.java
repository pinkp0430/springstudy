package com.wind.web.dto;

public class EngineerMajorDto {
	
	private int eng_id;
	private int maj_id;
	
	public EngineerMajorDto() {
		super();
	}

	public EngineerMajorDto(int eng_id, int maj_id) {
		super();
		this.eng_id = eng_id;
		this.maj_id = maj_id;
	}

	public int getEng_id() {
		return eng_id;
	}

	public void setEng_id(int eng_id) {
		this.eng_id = eng_id;
	}

	public int getMaj_id() {
		return maj_id;
	}

	public void setMaj_id(int maj_id) {
		this.maj_id = maj_id;
	}

	
	
}
