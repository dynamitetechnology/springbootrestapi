package com.dynamite.crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamite.crud.Dao.Dao;
import com.dynamite.crud.Modal.User;



@Service
public class LoginService {

		@Autowired
		Dao dao;
		
		public int createUser(User user) {
			return dao.createUser(user);
		}
		
		
		public String checkuser(String username) {
			return dao.checkuser(username);
		}
		
		public String logincheck(String username, String password) {
			return dao.logincheck(username,password);
		}
}

