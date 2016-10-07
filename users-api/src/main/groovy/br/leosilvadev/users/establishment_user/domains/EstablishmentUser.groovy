package br.leosilvadev.users.establishment_user.domains

import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import org.apache.commons.lang.RandomStringUtils
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection='establishment_users')
class EstablishmentUser {

	@Id
	String id
	
	String name
	
	@NotNull
	String email
	
	@NotNull
	String password
	
	@NotNull
	Boolean active
	
	@NotNull
	Boolean blocked

	@NotNull
	LocalDateTime registrationDatetime

	@NotNull
	LocalDateTime lastUpdateDatetime
	
	EstablishmentUser() {
		this.active = Boolean.TRUE
		this.blocked = Boolean.TRUE
		this.registrationDatetime = LocalDateTime.now()
		this.lastUpdateDatetime = LocalDateTime.now()
	}
	
	EstablishmentUser(String email) {
		this()
		this.email = email
		this.password = RandomStringUtils.random(6)
	}
}
