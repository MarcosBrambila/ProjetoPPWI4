package com.lojaconstrucao.models.service.exception;

import com.lojaconstrucao.models.service.exception.BusinessException;

public class EmailAlreadyExistsException extends BusinessException {

	private static final long serialVersionUID = -350468774335783591L;

	public EmailAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmailAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}