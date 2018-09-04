package com.wind.web.dao;


import java.sql.Timestamp;
import java.util.ArrayList;

import com.wind.web.dto.AirportDto;
import com.wind.web.dto.CountryDto;
import com.wind.web.dto.TicketAllDto;
import com.wind.web.dto.TicketDto;

public interface SearchDao {

	public ArrayList<TicketAllDto> low_price_listDao(String country);
	public TicketAllDto ticket_portDao(int id);
	public String countDao(String flight_code, String arrive, Timestamp dep_time);
	
//******************** 안쓰는 것들
	public ArrayList<TicketDto> ticket_port_listDao(String arrive);
	public ArrayList<TicketAllDto> country_ticketsDao(String continent, String c_code);
	public ArrayList<TicketDto> low_priceDao();
	
	
}
