package com.wind.web.dao;


import java.sql.Timestamp;
import java.util.ArrayList;

import com.wind.web.dto.AirportDto;
import com.wind.web.dto.CountryDto;
import com.wind.web.dto.LowPriceContinentDto;
import com.wind.web.dto.TicketAllDto;
import com.wind.web.dto.TicketDto;

public interface PayDao {

	public void pay_confirmDao(String flight_code, String arrive, Timestamp dep_time, String count);

	public ArrayList<TicketDto> pay_listDao(String parameter, String parameter2, Timestamp valueOf, String parameter3);



}
