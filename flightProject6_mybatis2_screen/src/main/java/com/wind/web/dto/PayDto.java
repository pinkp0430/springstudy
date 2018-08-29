package com.wind.web.dto;

import java.sql.Timestamp;

public class PayDto {
	
	private String pay_id;
	private String username;
	private String total_price;
	private String payment_mt; //결제방법
	private Timestamp pay_time;
	
	public PayDto() {
		super();
	}

	public PayDto(String pay_id, String username, String total_price, String payment_mt, Timestamp pay_time) {
		super();
		this.pay_id = pay_id;
		this.username = username;
		this.total_price = total_price;
		this.payment_mt = payment_mt;
		this.pay_time = pay_time;
	}

	public String getPay_id() {
		return pay_id;
	}

	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public String getPayment_mt() {
		return payment_mt;
	}

	public void setPayment_mt(String payment_mt) {
		this.payment_mt = payment_mt;
	}

	public Timestamp getPay_time() {
		return pay_time;
	}

	public void setPay_time(Timestamp pay_time) {
		this.pay_time = pay_time;
	}

	
}
