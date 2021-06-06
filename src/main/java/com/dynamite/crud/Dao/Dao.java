package com.dynamite.crud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dynamite.crud.Modal.User;

@Repository("dao")
public class Dao {

	
	@Autowired
	   private  JdbcTemplate jdbcTemplate;
	
	public int createUser(User user) {
		String INSERT_QUERY="INSERT INTO users(username, email,password) VALUES (?,?,?)";
		return jdbcTemplate.update(INSERT_QUERY, user.getUsername(),user.getEmail(),user.getPassword());
}
	
	
	public String checkuser(String username) {
		String INSERT_QUERY="select count(username) from  users where username  = ?";
		return jdbcTemplate.queryForObject(INSERT_QUERY, String.class, new Object[]{username});		
}
	
	
	public String logincheck(String username,String password) {
		String INSERT_QUERY="select count(username) from  users where username  = ? and password = ? ";
		return jdbcTemplate.queryForObject(INSERT_QUERY, String.class, new Object[]{username, password});		
}
	
}
