package com.wind.web.dao;

import java.util.ArrayList;
import com.wind.web.dto.AirlineDto;

public interface AirlineDao {

	public ArrayList<AirlineDto> airline_listDao();
	public void inputAirlineDao(String a_code, String a_name);
	public void airline_deleteDao(String a_code);

}
