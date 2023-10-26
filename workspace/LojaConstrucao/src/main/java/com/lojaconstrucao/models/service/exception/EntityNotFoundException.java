package com.lojaconstrucao.models.service.exception;

import com.lojaconstrucao.models.service.exception.BusinessException;

public class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = -1469455524594842935L;

	public EntityNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
