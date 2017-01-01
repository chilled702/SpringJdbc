package com.example.DAO;

import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
    public BaseDAO(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insertDate(){
		TimeZone.setDefault(TimeZone.getTimeZone("PST"));
		jdbcTemplate.update("DELETE FROM processing_date;insert into processing_date values("+new Date()+")");
	}
	
	public Date getLocalDate(){
		Date date = new Date();
		date = jdbcTemplate.queryForObject("select processing_dt from processing_date", Date.class);
		return date;
	}
	
	public void rollLocalDate(){
		jdbcTemplate.update("update processing_date set processing_dt=processing_dt"+1);
	}
}
