package com.poc.ilovegithubweb.common.exception;

import com.poc.ilovegithubweb.common.response.ErrorCode;

public class InvalidParamException extends BaseException {

	public InvalidParamException() {
		super(ErrorCode.COMMON_INVALID_PARAMETER);
	}

	public InvalidParamException(ErrorCode errorCode) {
		super(errorCode);
	}

	public InvalidParamException(String errorMsg) {
		super(errorMsg, ErrorCode.COMMON_INVALID_PARAMETER);
	}

	public InvalidParamException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}
}
