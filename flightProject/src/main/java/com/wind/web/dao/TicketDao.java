package com.wind.web.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.wind.web.dto.AirportDto;
import com.wind.web.dto.TicketDto;

public class TicketDao {
	
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public TicketDao() {
		super();
	}

	public void inputTicket(final String airline, final String flight_name, final String departure, 
			final String arrive, final Timestamp dep_time, final Timestamp arri_time, final String seat_able, 
			final String seat_price) {
		
		String query1 = "select port_name from airportTB where port_code = '" + departure + "'";
		final String name1 = (String) template.queryForObject(query1, String.class);

		String query2 = "insert into ticketTB(ticket_id, airline, flight_name, departure, arrive, dep_time, "
				+ "arri_time, seat_able, seat_price, dName) values (ticketTB_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(query2, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, airline);
				ps.setString(2, flight_name);
				ps.setString(3, departure);
				ps.setString(4, arrive);
				ps.setTimestamp(5, dep_time);
				ps.setTimestamp(6, arri_time);
				ps.setString(7, seat_able);
				ps.setString(8, seat_price);
				ps.setString(9, name1);
//				ps.setString(10, stime);
			}
		});
	}

	public ArrayList<TicketDto> list() {
		String query = "select * from ticketTB order by ticket_id desc";
		return (ArrayList<TicketDto>) template.query(query, new BeanPropertyRowMapper<TicketDto>(TicketDto.class));
	}
	
	public void delete(final String ticket_id) {
		String query = "delete from ticketTB where ticket_id = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, ticket_id);
			}
		});
	}

	public TicketDto low_price() {
		String query = "select * from ticketTB where seat_price = (select min(seat_price) from ticketTB)";
		return template.queryForObject(query, new BeanPropertyRowMapper<TicketDto>(TicketDto.class));
	}
	
//	public ArrayList<TicketDto> continent_tickets() {
//		String query = "select * from ticketTB where arrive in (select port_code from airportTB where port_continent = 'america')";
//		return (ArrayList<TicketDto>) template.query(query, new BeanPropertyRowMapper<TicketDto>(TicketDto.class));
//	}
	
	public ArrayList<TicketDto> continent_tickets(String continent) {
		System.out.println("continent = " + continent);
		String query = "select * from ticketTB where arrive in (select port_code from airportTB "
				+ "where port_continent = '" + continent + "') order by seat_price ";
		return (ArrayList<TicketDto>) template.query(query, new BeanPropertyRowMapper<TicketDto>(TicketDto.class));
	}

}
