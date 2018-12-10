package com.mql.notesProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mql.notesProject.entities.User;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
