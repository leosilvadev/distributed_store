package br.leosilvadev.establishments.establishment.domains

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.Email
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@EqualsAndHashCode
@ToString
@Document
class Establishment {

	@Id
	String id

	@NotNull
	String name

	@NotNull
	@Email
	String email

	@NotNull
	String documentNumber

	@NotNull
	LocalDateTime registrationDatetime

	@NotNull
	LocalDateTime lastUpdateDatetime

	@Field
	Map config

	Establishment() {
		this.registrationDatetime = LocalDateTime.now()
		this.lastUpdateDatetime = LocalDateTime.now()
	}

	Establishment(String name, String email,String documentNumber, Map config = [:]) {
		this()
		this.name = name
		this.email = email
		this.documentNumber = documentNumber
		this.config = config
	}
}
