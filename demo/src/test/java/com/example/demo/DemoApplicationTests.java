package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import hello.Application;
import hello.Customer;
import hello.CustomerMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(
		  classes = {  Application.class })
@SpringBootTest
public class DemoApplicationTests  {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void testGetFirstName() {
		
        String sql = "SELECT id, first_name, last_name FROM customers WHERE first_name = ?";
        List<Customer> customers = jdbcTemplate.query(
                sql, new Object[] { "Maan" },
                new CustomerMapper());
        
        assertEquals("Maan", customers.get(0).getFirstName());
	}
	
	@Test
	public void testGetLastName() {
		
        String sql = "SELECT id, first_name, last_name FROM customers WHERE last_name = ?";
        List<Customer> customers = jdbcTemplate.query(
                sql, new Object[] { "alkhelewi" },
                new CustomerMapper());
        
        assertEquals("Alkhelewi", customers.get(0).getLastName());
	}

}
