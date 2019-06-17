package com.kgate.exception;

public class ResourceNotFoundExceptionTest extends Exception{

	 
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceptionTest(Object resouceId) {
		super(resouceId !=null ? resouceId.toString() : null);
	}

}
