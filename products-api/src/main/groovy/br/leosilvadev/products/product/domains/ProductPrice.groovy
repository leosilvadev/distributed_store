package br.leosilvadev.products.product.domains

import java.time.LocalDateTime

import javax.validation.constraints.NotNull

class ProductPrice {

	@NotNull
	BigDecimal price

	@NotNull
	LocalDateTime registrationDatetime

	LocalDateTime validationBegin
	LocalDateTime validationEnd

	ProductPrice() {
		registrationDatetime = LocalDateTime.now()
	}

	ProductPrice(BigDecimal price) {
		this()
		this.price = price
	}

	ProductPrice(BigDecimal price, LocalDateTime validationBegin, LocalDateTime validationEnd) {
		this()
		this.price = price
	}
}
