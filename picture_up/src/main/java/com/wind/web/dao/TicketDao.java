package com.wind.web.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.wind.web.dto.AirportDto;
import com.wind.web.dto.TicketDto;

public interface TicketDao {

	public ArrayList<TicketDto> ticket_listDao();
	public void inputTicketDao(String flight_code, String departure, String arrive,
			Timestamp dep_time, Timestamp flight_time, Timestamp arri_time, int price, String md);
	public void ticket_deleteDao(String ticket_id);

}
