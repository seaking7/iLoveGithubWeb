package com.poc.ilovegithubweb.common.response;

import java.util.List;

import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.MDC;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;
import com.poc.ilovegithubweb.common.exception.BaseException;
import com.poc.ilovegithubweb.common.interceptor.CommonHttpRequestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

	private static final List<ErrorCode> SPECIFIC_ALERT_TARGET_ERROR_CODE_LIST = Lists.newArrayList();

	/**
	 * http status: 500 AND result: FAIL
	 * 시스템 예외 상황. 집중 모니터링 대상
	 *
	 * @param exception
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public CommonResponse onException(Exception exception) {
		String eventId = MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
		log.error("eventId = {} ", eventId, exception);
		return CommonResponse.fail(ErrorCode.COMMON_SYSTEM_ERROR);
	}

	/**
	 * http status: 200 AND result: FAIL
	 * 시스템은 이슈 없고, 비즈니스 로직 처리에서 에러가 발생함
	 *
	 * @param exception
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = BaseException.class)
	public CommonResponse onBaseException(BaseException exception) {
		String eventId = MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
		if (SPECIFIC_ALERT_TARGET_ERROR_CODE_LIST.contains(exception.getErrorCode())) {
			log.error("[BaseException] eventId = {}, cause = {}, errorMsg = {}", eventId,
				NestedExceptionUtils.getMostSpecificCause(exception),
				NestedExceptionUtils.getMostSpecificCause(exception).getMessage());
		} else {
			log.warn("[BaseException] eventId = {}, cause = {}, errorMsg = {}", eventId,
				NestedExceptionUtils.getMostSpecificCause(exception),
				NestedExceptionUtils.getMostSpecificCause(exception).getMessage());
		}
		return CommonResponse.fail(exception.getMessage(), exception.getErrorCode().name());
	}

	/**
	 * 예상치 않은 Exception 중에서 모니터링 skip 이 가능한 Exception 을 처리할 때
	 * ex) ClientAbortException
	 *
	 * @param exception
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = {ClientAbortException.class})
	public CommonResponse skipException(Exception exception) {
		String eventId = MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
		log.warn("[skipException] eventId = {}, cause = {}, errorMsg = {}", eventId,
			NestedExceptionUtils.getMostSpecificCause(exception),
			NestedExceptionUtils.getMostSpecificCause(exception).getMessage());
		return CommonResponse.fail(ErrorCode.COMMON_SYSTEM_ERROR);
	}

	/**
	 * http status: 400 AND result: FAIL
	 * request parameter 에러
	 *
	 * @param exception
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public CommonResponse methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		String eventId = MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
		log.warn("[BaseException] eventId = {}, errorMsg = {}", eventId,
			NestedExceptionUtils.getMostSpecificCause(exception).getMessage());
		BindingResult bindingResult = exception.getBindingResult();
		FieldError fe = bindingResult.getFieldError();
		if (fe != null) {
			String message =
				"Request Error" + " " + fe.getField() + "=" + fe.getRejectedValue() + " (" + fe.getDefaultMessage()
					+ ")";
			return CommonResponse.fail(message, ErrorCode.COMMON_INVALID_PARAMETER.name());
		} else {
			return CommonResponse.fail(ErrorCode.COMMON_INVALID_PARAMETER.getErrorMsg(),
				ErrorCode.COMMON_INVALID_PARAMETER.name());
		}
	}
}
