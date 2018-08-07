package com.wind.web.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.wind.web.dto.AirportDto;

public class AirportDao {
	
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public AirportDao() {}
	
	public void inputAirport(final String port_continent, final String port_country, final String port_code, final String port_name){
		String query = "insert into airportTB(port_continent, port_country, port_code, port_name) values (?,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{ 
			ps.setString(1, port_continent);
			ps.setString(2, port_country);
			ps.setString(3, port_code);
			ps.setString(4, port_name);
		}
		});
	}

	public ArrayList<AirportDto> list() {
		String query = "select port_continent, port_country, port_code, port_name from airportTB "
				+ "order by port_continent asc, port_country asc";
		return (ArrayList<AirportDto>) template.query(query, new BeanPropertyRowMapper<AirportDto>(AirportDto.class));
	}

	public void delete(final String port_code) {
		String query = "delete from airportTB where port_code = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, port_code);
			}
		});
		
	}

//	public boolean aCodeCheck(final String pcode) {
//		String query = "select * from airportTB where port_code = " + pcode;
//		AirportDto result = null;
//		result = template.queryForObject(query, new BeanPropertyRowMapper<AirportDto>(AirportDto.class));
//		
//		if(result.equals(null)) {
//			return true;
//		} else return false;
//	}
	
	
}
