package br.leosilvadev.products.product.domains


import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="products")
@CompoundIndexes([
	@CompoundIndex(name = "unique_name", unique = true, def = "{'name' : 1, 'establishmentId' : 1}")
])
class Product {

	@Id
	String id
	
	@Indexed
	@NotNull
	String name
	
	@NotNull
	String description
	
	@NotNull
	String establishmentId

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

	Product(String name, String description, BigDecimal price, String establishmentId) {
		this()
		this.name = name
		this.description = description
		this.prices = [new ProductPrice(price)]
		this.establishmentId = establishmentId
	}
}
