package br.leosilvadev.products.domains

import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class Product {

	@Id
	String id

	@NotNull
	String name

	@NotNull
	String description

	@Field
	@NotNull
	List<ProductPrice> prices

	@NotNull
	LocalDateTime registrationDatetime

	@NotNull
	LocalDateTime lastUpdateDatetime

	Product() {
		this.registrationDatetime = LocalDateTime.now()
		this.lastUpdateDatetime = LocalDateTime.now()
	}

	Product(String name, String description, BigDecimal price) {
		this()
		this.name = name
		this.description = description
		this.prices = Arrays.asList(new ProductPrice(price))
	}
}
