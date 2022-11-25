package com.poc.ilovegithubweb.common.exception;

import com.poc.ilovegithubweb.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {

	public EntityNotFoundException() {
		super(ErrorCode.COMMON_INVALID_PARAMETER);
	}

	public EntityNotFoundException(String message) {
		super(message, ErrorCode.COMMON_INVALID_PARAMETER);
	}
}
