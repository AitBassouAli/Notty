package com.mql.notesProject.exceptions;

public class FileNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918196603966346360L;

	public FileNotFoundException(String message, Throwable ex) {
		super(message, ex);
	}

	public FileNotFoundException(String message) {
		super(message);
	}
}
