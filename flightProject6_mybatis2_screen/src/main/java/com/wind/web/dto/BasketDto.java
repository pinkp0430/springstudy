package com.wind.web.dto;

public class BasketDto {
	
	private int basket_id;
	private int user_id;
	private int ticket_id;
	private int cnt;
	private int validity;
	
	public BasketDto() {
		super();
	}

	public BasketDto(int basket_id, int user_id, int ticket_id, int cnt, int validity) {
		super();
		this.basket_id = basket_id;
		this.user_id = user_id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

