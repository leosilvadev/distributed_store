package br.leosilvadev.products.product.v1

import javax.validation.constraints.NotNull

import br.leosilvadev.products.product.domains.Product

class RegistrationRequest {

	@NotNull
	String name

	@NotNull
	String description

	@NotNull
	BigDecimal price

	Product toDomain(String establishmentId) {
		new Product(name, description, price, establishmentId)
	}
}
