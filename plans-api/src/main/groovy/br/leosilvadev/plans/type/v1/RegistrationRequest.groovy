package br.leosilvadev.plans.type.v1

import javax.validation.constraints.NotNull

import br.leosilvadev.plans.domains.PlanType

class RegistrationRequest {

	@NotNull
	String name

	@NotNull
	String description

	@NotNull
	BigDecimal price

	PlanType toDomain() {
		new PlanType(name, description, price)
	}
}
