package com.mql.notesProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mql.notesProject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
