package br.leosilvadev.users.establishment_user.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.users.establishment_user.domains.EstablishmentUser

@Repository
interface EstablishmentUserRepository extends MongoRepository<EstablishmentUser, String> {
}
