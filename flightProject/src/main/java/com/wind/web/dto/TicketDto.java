package com.wind.web.dto;

import java.sql.Timestamp;

public class TicketDto {
	
	  private int ticket_id;
	  private String airline;
	  private String flight_name;
	  private String departure;
	  private String arrive;
	  private Timestamp dep_time;
	  private Timestamp arri_time;
	  private int seat_able;
	  private int seat_price;
//	  private Timestamp dtime;
	  private String dName;
		  
	  public TicketDto() {
		super();
	  }

	  public TicketDto(int ticket_id, String airline, String flight_name, String departure, String arrive,
			  Timestamp dep_time, Timestamp arri_time, int seat_able, int seat_price, String dName) {
		super();
		this.ticket_id = ticket_id;
		this.airline = airline;
		this.flight_name = flight_name;
		this.departure = departure;
		this.arrive = arrive;
		this.dep_time = dep_time;
		this.arri_time = arri_time;
		this.seat_able = seat_able;
		this.seat_price = seat_price;
		this.dName = dName;
//		this.stime = stime;
	}

	  
//	public String getStime() {
//		return stime;
//	}
//
//	public void setStime(String stime) {
//		this.stime = stime;
//	}
//
//	public Timestamp getDtime() {
//		return dtime;
//	}
//
//	public void setDtime(Timestamp dtime) {
//		this.dtime = dtime;
//	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}	
 
	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
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

	public Timestamp getArri_time() {
		return arri_time;
	}

	public void setArri_time(Timestamp arri_time) {
		this.arri_time = arri_time;
	}

	public int getSeat_able() {
		return seat_able;
	}

	public void setSeat_able(int seat_able) {
		this.seat_able = seat_able;
	}

	public int getSeat_price() {
		return seat_price;
	}

	public void setSeat_price(int seat_price) {
		this.seat_price = seat_price;
	}
	  
}
