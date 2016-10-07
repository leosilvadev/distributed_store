package br.leosilvadev.products.handlers

import groovy.util.logging.Slf4j

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@Slf4j
@ControllerAdvice
class ControllerExceptionHandler {

	
	@ResponseStatus(value=HttpStatus.CONFLICT, reason='Invalid operation, check the data and try again.')
	@ExceptionHandler(DuplicateKeyException)
	void handleException(DuplicateKeyException ex) {
		log.error(ex.message, ex)
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason='Internal Error. We are working on that.')
	@ExceptionHandler(Exception)
	void handleException(Exception ex) {
		log.error(ex.message, ex)
	}
}
