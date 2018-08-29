package com.wind.web.dto;

import java.sql.Timestamp;

public class TicketAllDto {

	private int ticket_id;
	private String flight_code;
	private String air_name;
	  
	private String departure;
	private String dep_name;

	private Timestamp dep_time;
	private Timestamp flight_time;
	private Timestamp arri_time;
	  
	private String arrive;
	private String arri_name;
	private String arri_country;
	private String continent;
	
	private int seat_able;
	private int first_seat;
	private String md;
	
	private int price;

	
	public TicketAllDto() {
		super();
	}
	
	public TicketAllDto(int ticket_id, String flight_code, String air_name, String departure, String dep_name,
			Timestamp dep_time, Timestamp flight_time, Timestamp arri_time, String arrive, String arri_name,
			String arri_country, String continent, int seat_able, int first_seat, String md, int price) {
		super();
		this.ticket_id = ticket_id;
		this.flight_code = flight_code;
		this.air_name = air_name;
		this.departure = departure;
		this.dep_name = dep_name;
		this.dep_time = dep_time;
		this.flight_time = flight_time;
		this.arri_time = arri_time;
		this.arrive = arrive;
		this.arri_name = arri_name;
		this.arri_country = arri_country;
		this.continent = continent;
		this.seat_able = seat_able;
		this.first_seat = first_seat;
		this.md = md;
		this.price = price;
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

	public String getAir_name() {
		return air_name;
	}

	public void setAir_name(String air_name) {
		this.air_name = air_name;
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

	public Timestamp getDep_time() {
		return dep_time;
	}

	public void setDep_time(Timestamp dep_time) {
		this.dep_time = dep_time;
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

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getArri_name() {
		return arri_name;
	}

	public void setArri_name(String arri_name) {
		this.arri_name = arri_name;
	}

	public String getArri_country() {
		return arri_country;
	}

	public void setArri_country(String arri_country) {
		this.arri_country = arri_country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	  
	  




}
