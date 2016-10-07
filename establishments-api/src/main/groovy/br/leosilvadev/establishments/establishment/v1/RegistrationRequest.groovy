package br.leosilvadev.establishments.establishment.v1

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import org.hibernate.validator.constraints.Email

import br.leosilvadev.establishments.establishment.domains.Establishment

class RegistrationRequest {

	@NotNull
	@Size(min=4, max=255)
	String name

	@NotNull
	@Email
	String email

	@NotNull
	@Size(min=8, max=50)
	String documentNumber
	
	Establishment toDomain() {
		new Establishment(name, email, documentNumber)
	}
}
