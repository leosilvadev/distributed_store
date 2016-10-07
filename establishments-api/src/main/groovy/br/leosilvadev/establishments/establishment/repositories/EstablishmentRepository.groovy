package br.leosilvadev.establishments.establishment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.establishments.establishment.domains.Establishment

@Repository
interface EstablishmentRepository extends MongoRepository<Establishment, String> {
}
