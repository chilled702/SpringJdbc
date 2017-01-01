package com.example;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.DAO.BaseDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	BaseDAO baseDAO ;
	
	/*@Before
	public void init(){
		baseDAO = new BaseDAO(jdbcTemplate);
	}*/
	
	
	@Test
	public void insertDate(){
		
		baseDAO.insertDate();
		Date date = baseDAO.getLocalDate();
		System.out.println("=============================================="+date+"=============================================");
		assertTrue("Dates are same!",date==new Date());
	}
	
	@Test
	public void rollDate() {
		Date date = baseDAO.getLocalDate();
		
	}
	
	@Test
	public void getLocalDate(){
		Date date = baseDAO.getLocalDate();
		System.out.println("=============================================="+date+"=============================================");
		TimeZone.setDefault(TimeZone.getTimeZone("EDT"));
		assertTrue("Dates are not same!",date==new Date());
	}

}
