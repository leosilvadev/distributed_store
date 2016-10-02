package br.leosilvadev.products.v1

import javax.validation.constraints.NotNull

import br.leosilvadev.products.domains.Product

class RegistrationRequest {

	@NotNull
	String name;

	@NotNull
	String description;

	@NotNull
	BigDecimal price;

	public Product toDomain() {
		return new Product(name, description, price)
	}
}
