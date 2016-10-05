package br.leosilvadev.plans.type.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.plans.domains.PlanType

@Repository
interface PlanTypeRepository extends MongoRepository<PlanType, String> {
}
