package br.leosilvadev.products.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason='Invalid establishment')
class InvalidEstablishmentException extends RuntimeException {
}
