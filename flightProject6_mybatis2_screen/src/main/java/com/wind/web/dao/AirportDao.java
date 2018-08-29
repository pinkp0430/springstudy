package com.wind.web.dao;

import java.util.ArrayList;
import com.wind.web.dto.AirportDto;

public interface AirportDao {

	public ArrayList<AirportDto> airport_listDao();
	public void inputAirportDao(String ap_code, String ap_name, String country_code);
	public void airport_deleteDao(String ap_code);

}
