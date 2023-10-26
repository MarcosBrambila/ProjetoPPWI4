package com.lojaconstrucao.models.service.exception;

import com.lojaconstrucao.models.service.exception.BusinessException;

public class PasswordConfirmationException extends BusinessException {

	private static final long serialVersionUID = 8818862794678051542L;

	public PasswordConfirmationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordConfirmationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
