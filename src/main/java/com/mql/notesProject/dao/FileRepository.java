package com.mql.notesProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mql.notesProject.entities.UploadFileResponse;

public interface FileRepository extends JpaRepository< UploadFileResponse, Long>{

	List<UploadFileResponse> findByNoteId(Long id);

}
