package com.mql.notesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mql.notesProject.dao.NoteRepository;
import com.mql.notesProject.entities.Note;
import com.mql.notesProject.entities.User;
import com.mql.notesProject.property.FileStorageProperties;
import com.mql.notesProject.service.AccountService;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class NotesProjectApplication implements CommandLineRunner {
	@Autowired
	AccountService accountService;
	@Autowired
	NoteRepository noteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(NotesProjectApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		accountService.AddUser(new User(null,"ahmed","khachani"));
//		accountService.AddUser(new User(null,"ali","a"));
//		noteRepository.save(new Note(null, "khachani Note", "premierTest", null, null, null, null));
		
		
	}
	
}
