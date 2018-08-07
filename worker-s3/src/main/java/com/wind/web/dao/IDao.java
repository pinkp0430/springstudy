package com.wind.web.dao;
import java.util.ArrayList;

import com.wind.web.dto.EngineerDto;
import com.wind.web.dto.EngineerMajorDto;
import com.wind.web.dto.MajorDto;

public interface IDao {

	public ArrayList<MajorDto> majorlistDao();
	public ArrayList<MajorDto> majorselect_viewDao();	
	public ArrayList<EngineerMajorDto> majorselectDao(int maj_id);
	public EngineerDto majorselect2Dao(int eng_id);
	public ArrayList<EngineerDto> majorselect3Dao(int id);
	
}
