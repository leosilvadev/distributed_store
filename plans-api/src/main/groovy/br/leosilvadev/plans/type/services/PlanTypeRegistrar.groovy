package br.leosilvadev.plans.type.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.plans.type.domains.PlanType
import br.leosilvadev.plans.type.repositories.PlanTypeRepository

@Service
class PlanTypeRegistrar {

	@Autowired
	PlanTypeRepository planTypeRepository

	def register(PlanType type) {
		planTypeRepository.save type
	}
}
