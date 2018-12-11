package com.mql.notesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mql.notesProject.dao.FileRepository;
import com.mql.notesProject.dao.NoteRepository;
import com.mql.notesProject.entities.Note;
import com.mql.notesProject.entities.UploadFileResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private FileRepository fileRepository;

	@RequestMapping(value = "/notes")
	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	@RequestMapping(value = "/notes/{id}")
	public Note getOne(@PathVariable Long id) {
		System.out.println(noteRepository.getOne(id));
		return noteRepository.getOne(id);
	}

	@RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		noteRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/notes/{id}/files")
	public List<UploadFileResponse> getFiles(@PathVariable Long id) {
		return fileRepository.findByNoteId(id);
	}

	@RequestMapping(value = "/notes", method = RequestMethod.POST)
	public Note create(@RequestBody Note note) {
		return noteRepository.save(note);
	}

	@RequestMapping(value = "/notes", method = RequestMethod.PUT)
	public Note update(@RequestBody Note note) {
		return noteRepository.save(note);
	}

}
