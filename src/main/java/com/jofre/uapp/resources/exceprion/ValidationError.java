package com.jofre.uapp.resources.exceprion;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage>erro = new ArrayList<>();
	
	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return erro;
	}

	public void addError(String fieldName, String message) {
		erro.add(new FieldMessage(fieldName,message));
	}

	
	
}
