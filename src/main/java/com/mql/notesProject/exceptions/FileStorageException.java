package com.mql.notesProject.exceptions;

public class FileStorageException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4813439330895072269L;

	public FileStorageException(String message, Throwable ex) {
		super(message, ex);
	}

	public FileStorageException(String message) {
		super(message);
	}

}
