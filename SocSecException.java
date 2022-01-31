package com.exception;

public class SocSecException extends Exception {
	
	/**
	 * 
	 * @param error
	 */
	public SocSecException(String error) {
		
		super("Invalid social security number, "+error);
	}
}
