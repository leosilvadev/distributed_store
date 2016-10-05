package br.leosilvadev.establishments.repositories;

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.establishments.domains.Establishment

@Repository
interface EstablishmentRepository extends MongoRepository<Establishment, String> {
}
