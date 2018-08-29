package com.wind.web.dto;

public class BasketDto {
	
	private int basket_id;
	private int username;
	private int ticket_id;
	private int cnt;
	private int validity;
	
	public BasketDto() {
		super();
	}

	public BasketDto(int basket_id, int username, int ticket_id, int cnt, int validity) {
		super();
		this.basket_id = basket_id;
		this.username = username;
		this.ticket_id = ticket_id;
		this.cnt = cnt;
		this.validity = validity;
	}

	public int getBasket_id() {
		return basket_id;
	}

	public void setBasket_id(int basket_id) {
		this.basket_id = basket_id;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int user_id) {
		this.username = user_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}
	
	

}

