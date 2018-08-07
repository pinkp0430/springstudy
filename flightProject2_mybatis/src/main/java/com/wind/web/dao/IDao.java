package com.wind.web.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.wind.web.dto.AirportDto;
import com.wind.web.dto.TicketDto;

public interface IDao {

	public ArrayList<AirportDto> airport_listDao();
	public void inputAirportDao(String port_continent, String port_country, String port_code, String port_name);
	public void airport_deleteDao(String port_code);
	
	public ArrayList<TicketDto> ticket_listDao();
	public void inputTicketDao(String airline, String flight_name, String departure, String arrive,
			Timestamp dep_time, Timestamp arri_time, String seat_able, String seat_price, String dName, String aName);
	public void ticket_deleteDao(String ticket_id);
	public String getPort_nameDao(String port_code);
	
	public TicketDto low_priceDao();
	public ArrayList<TicketDto> continent_ticketsDao(String continent);

	

}
