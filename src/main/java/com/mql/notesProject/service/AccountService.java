package com.mql.notesProject.service;

import com.mql.notesProject.entities.User;

public interface AccountService {
	public User findByUsername(String username);
	public User AddUser(User user);

}
