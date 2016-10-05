package br.leosilvadev.plans.domains

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection='planTypes')
class PlanType {

	@Id
	String id

	@NotNull
	String name

	@NotNull
	String description

	@NotNull
	BigDecimal price

	@NotNull
	LocalDateTime registrationDatetime

	@NotNull
	LocalDateTime lastUpdateDatetime
	
	PlanType(){
		this.registrationDatetime = LocalDateTime.now()
		this.lastUpdateDatetime = LocalDateTime.now()
	}
	
	PlanType(String name, String description, BigDecimal price) {
		this()
		this.name = name
		this.description = description
		this.price = price
	}
}