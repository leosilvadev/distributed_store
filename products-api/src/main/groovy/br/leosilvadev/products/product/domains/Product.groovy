package br.leosilvadev.products.product.domains

import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="products")
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
		this.prices = [new ProductPrice(price)]
	}
}
