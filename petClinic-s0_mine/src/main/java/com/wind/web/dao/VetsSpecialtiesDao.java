package com.wind.web.dao;
import java.util.ArrayList;

import com.wind.web.dto.SpecialtiesDto;
import com.wind.web.dto.VetspecialtiesDto;

public interface VetsSpecialtiesDao {

	public void vetspec_deleteDao(String id);

	public void add_vetspecDao(String vet_id, String specialty_id);

	public ArrayList<VetspecialtiesDto> vetspeslistDao();
	
}
