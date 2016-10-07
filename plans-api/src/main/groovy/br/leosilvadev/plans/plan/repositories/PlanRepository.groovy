package br.leosilvadev.plans.plan.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.plans.plan.domains.Plan

@Repository
interface PlanRepository extends MongoRepository<Plan, String> {
}
