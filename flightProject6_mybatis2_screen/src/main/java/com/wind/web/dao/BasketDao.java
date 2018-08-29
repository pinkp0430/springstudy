package com.wind.web.dao;

import java.util.ArrayList;

import com.wind.web.dto.TicketAllDto;
import com.wind.web.dto.TicketBuyDto;

public interface BasketDao {

	public void basket_inputDao(String sess_id, int id, int count);

	public int basket_getCntDao(String sess_id, int id);

	public void basket_updateDao(String sess_id, int id, int sum);

	public ArrayList<TicketBuyDto> basket_listDao(String sess_id);

	public void basket_deleteDao(String sess_id, int id);

	public TicketBuyDto basket_checkDao(String sess_id, int id);

	public int getableCntDao(int ticket_id);

	public void paidUpdateDao(String username, int ticket_id);





}
