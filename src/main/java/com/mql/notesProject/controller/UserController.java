package com.mql.notesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mql.notesProject.dao.UserRepository;
import com.mql.notesProject.entities.User;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}

}
