package com.plivo.helper.exception;

public class PlivoException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String Message;

	public PlivoException(String message)
	{
		Message = message;
	}

	public String getMessage(){
		return Message;
	}
}