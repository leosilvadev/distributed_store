package br.leosilvadev.users.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.users.domains.EstablishmentUser

@Repository
interface EstablishmentUserRepository extends MongoRepository<EstablishmentUser, String> {
}
