package com.wind.web.dto;

import java.sql.Timestamp;

public class TicketDto {
	
	private int ticket_id;
	private String flight_code;
	private String departure;
	private String arrive;
	private Timestamp dep_time;
	private String flight_time;
	private Timestamp arri_time;
	private int price;
	private int seat_able;
	private int first_seat;
	private String md;
	  
	public TicketDto() {
		super();
	}

	public TicketDto(int ticket_id, String flight_code, String departure, String arrive, Timestamp dep_time,
			String flight_time, Timestamp arri_time, int price, int seat_able, int first_seat, String md) {
		super();
		this.ticket_id = ticket_id;
		this.flight_code = flight_code;
		this.departure = departure;
		this.arrive = arrive;
		this.dep_time = dep_time;
		this.flight_time = flight_time;
		this.arri_time = arri_time;
		this.price = price;
		this.seat_able = seat_able;
		this.first_seat = first_seat;
		this.md = md;
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

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public Timestamp getDep_time() {
		return dep_time;
	}

	public void setDep_time(Timestamp dep_time) {
		this.dep_time = dep_time;
	}

	public String getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(String flight_time) {
		this.flight_time = flight_time;
	}

	public Timestamp getArri_time() {
		return arri_time;
	}

	public void setArri_time(Timestamp arri_time) {
		this.arri_time = arri_time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSeat_able() {
		return seat_able;
	}

	public void setSeat_able(int seat_able) {
		this.seat_able = seat_able;
	}

	public int getFirst_seat() {
		return first_seat;
	}

	public void setFirst_seat(int first_seat) {
		this.first_seat = first_seat;
	}

	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}

	
	  
	  
}
