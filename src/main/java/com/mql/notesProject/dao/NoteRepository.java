package com.mql.notesProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mql.notesProject.entities.Note;

@RepositoryRestResource(path="notes", collectionResourceRel="notes")
public interface NoteRepository  extends JpaRepository<Note, Long>{
	
}
