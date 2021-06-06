package com.dynamite.crud.loginController;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.dynamite.crud.Modal.User;
import com.dynamite.crud.Service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class loginController {

	@Autowired
	LoginService loginservice;
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signup(@RequestBody String json) throws JsonMappingException, JsonProcessingException{

		ObjectMapper objMapper = new ObjectMapper();
		User user = objMapper.readValue(json, User.class);
	  
	 String username =  loginservice.checkuser(user.getUsername());
	 
	 int userTrue  = Integer.parseInt(username);  	 
	String jsonres = "";
	 if(userTrue > 0) {
		 jsonres = "{status:'Already Exist'}";
	 }else {
		 loginservice.createUser(user);
		 jsonres = "{status:'User Created'}";
	 }
	  return jsonres;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody String json) throws JsonMappingException, JsonProcessingException{

		ObjectMapper objMapper = new ObjectMapper();
		User user = objMapper.readValue(json, User.class);
	  
	 String username =  loginservice.logincheck(user.getUsername(), user.getPassword());
	 
	 int userTrue  = Integer.parseInt(username);  	 
	String jsonres = "";
	 if(userTrue > 0) {
		 jsonres = "{status:'Success'}";
	 }else {
		 jsonres = "{status:'Invalid username password'}";
	 }
	  return jsonres;
	}
	
}
