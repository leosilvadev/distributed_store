package br.leosilvadev.plans.domains

import java.time.LocalDate
import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import br.leosilvadev.plans.enumerations.PaymentStatus

class Payment {

	@NotNull
	BigDecimal price

	@NotNull
	LocalDate duedate

	LocalDateTime paymentDatetime

	@NotNull
	PaymentStatus status

	Payment(){}

	Payment(BigDecimal price, LocalDate duedate) {
		this.price = price
		this.duedate = duedate
		this.status = PaymentStatus.PENDING
	}
}
