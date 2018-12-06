package com.mql.notesProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mql.notesProject.dao.UserRepository;
import com.mql.notesProject.entities.User;

@Service
public class AccountImple implements AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
    
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User AddUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
   
	

}
