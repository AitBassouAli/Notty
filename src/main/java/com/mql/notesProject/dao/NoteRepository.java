package com.mql.notesProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mql.notesProject.entities.Note;
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@RepositoryRestResource(path="notes", collectionResourceRel="notes")
public interface NoteRepository  extends JpaRepository<Note, Long>{
	
}
