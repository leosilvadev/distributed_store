package br.leosilvadev.plans.plan.domains

import java.time.LocalDateTime

import javax.validation.constraints.NotNull

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

import br.leosilvadev.plans.type.domains.PlanType;

@Document(collection='plans')
class Plan {

	@Id
	String id

	@Field
	PlanType planType

	@NotNull
	List<Payment> payments

	@NotNull
	LocalDateTime registrationDatetime

	@NotNull
	LocalDateTime lastUpdateDatetime
}