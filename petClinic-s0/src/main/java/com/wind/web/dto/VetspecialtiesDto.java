package com.wind.web.dto;

public class VetspecialtiesDto {
	
	private int vet_id;
	private int special_id;
	
	public VetspecialtiesDto() {
		super();
	}

	public VetspecialtiesDto(int vet_id, int special_id) {
		super();
		this.vet_id = vet_id;
		this.special_id = special_id;
	}
	
	public int getVet_id() {
		return vet_id;
	}
	public void setVet_id(int vet_id) {
		this.vet_id = vet_id;
	}
	public int getSpecial_id() {
		return special_id;
	}
	public void setSpecial_id(int special_id) {
		this.special_id = special_id;
	}
	
	
	
}
