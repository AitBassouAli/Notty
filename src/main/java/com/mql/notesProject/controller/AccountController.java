package com.mql.notesProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mql.notesProject.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
}
