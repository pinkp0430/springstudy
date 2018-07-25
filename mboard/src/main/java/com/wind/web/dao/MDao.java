package com.wind.web.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.wind.web.dto.MDto;

public class MDao {

	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public MDao() {}
	
	public ArrayList<MDto> list() {
		ArrayList<MDto> dtos = null;
		String query = "select id, name, title, content from mboard order by id desc";
		dtos = (ArrayList<MDto>)template.query(query, new BeanPropertyRowMapper<MDto>(MDto.class));
		return dtos;
	}

	public MDto view(String strId) {
		String query = "select * from mboard where id = " + strId;		
		return template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}

	public void write(final String name, final String title, final String content) {
		String query = "insert into mboard(id, name, title, content) values (mboard_seq.nextval,?,?,?)";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, name);
				ps.setString(2, title);
				ps.setString(3, content);
			}
		});
	}

	public void delete(final String strId) {
		String query = "delete from mboard where id = ? " ;
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, strId);
			}
		});
	}
	
	

}
