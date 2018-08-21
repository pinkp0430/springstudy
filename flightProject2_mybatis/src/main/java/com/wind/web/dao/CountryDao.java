package com.wind.web.dao;

import java.util.ArrayList;
import com.wind.web.dto.CountryDto;

public interface CountryDao {

	public ArrayList<CountryDto> country_listDao();
	public void inputCountryDao(String c_code, String c_name, String continent);
	public void country_deleteDao(String c_code);
	public ArrayList<CountryDto> continent_listDao();
	
}
