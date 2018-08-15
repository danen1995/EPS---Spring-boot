package com.example.demo.klase;

import java.io.Serializable;

public class Wrapper<T> implements Serializable {
	//Korisnik
	public static final String USER_AUTHENTICATED = "201";
	public static final String USER_NOT_FOUND = "202";
	public static final String USER_PASSWORD_DOES_NOT_MATCH = "203";
	//Kupac
	public static final String BUYER_AUTHENTICATED = "301";
	public static final String BUYER_DOES_NOT_EXIST = "302";

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798383576654389947L;
	private String error;
	private String message;
	private T object;
	
	public Wrapper(String error, String message, T object) {
		super();
		this.error = error;
		this.message = message;
		this.object = object;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getObject() {
		return object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	
	
}
