package com.wind.web.dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.wind.web.dto.AirportDto;
import com.wind.web.dto.CountryDto;
import com.wind.web.dto.TicketAllDto;
import com.wind.web.dto.TicketDto;

public interface PayDao {

	public void pay_confirmDao(int id, int count);

	public ArrayList<TicketDto> pay_listDao(String parameter, String parameter2, Timestamp valueOf, String parameter3);

	public void paidInfo_inputDao(String username, int total, Date pay_time);

	public int getPay_idDao(String username);

	public void paidList_inputDao(int pay_id, int ticket_id, int count);



}
