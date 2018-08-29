package com.wind.web.dto;

import java.sql.Timestamp;

public class TicketBuyDto {

	private String continent;
	private int price;
	private String c_code;
	private String c_name;
	private Timestamp dep_time;
	  
	private int ticket_id;
	private String flight_code;
	private String departure;
	private String dep_name;
	private String arrive;
	private String country;
	private Timestamp flight_time;
	private Timestamp arri_time;
	private int seat_buy;
	
	public TicketBuyDto() {
		super();
	}

	public TicketBuyDto(String continent, int price, String c_code, String c_name, Timestamp dep_time, int ticket_id,
			String flight_code, String departure, String dep_name, String arrive, String country, Timestamp flight_time,
			Timestamp arri_time, int seat_buy) {
		super();
		this.continent = continent;
		this.price = price;
		this.c_code = c_code;
		this.c_name = c_name;
		this.dep_time = dep_time;
		this.ticket_id = ticket_id;
		this.flight_code = flight_code;
		this.departure = departure;
		this.dep_name = dep_name;
		this.arrive = arrive;
		this.country = country;
		this.flight_time = flight_time;
		this.arri_time = arri_time;
		this.seat_buy = seat_buy;
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

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public Timestamp getDep_time() {
		return dep_time;
	}

	public void setDep_time(Timestamp dep_time) {
		this.dep_time = dep_time;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getFlight_code() {
		return flight_code;
	}

	public void setFlight_code(String flight_code) {
		this.flight_code = flight_code;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(Timestamp flight_time) {
		this.flight_time = flight_time;
	}

	public Timestamp getArri_time() {
		return arri_time;
	}

	public void setArri_time(Timestamp arri_time) {
		this.arri_time = arri_time;
	}

	public int getSeat_buy() {
		return seat_buy;
	}

	public void setSeat_buy(int seat_buy) {
		this.seat_buy = seat_buy;
	}

	

}
