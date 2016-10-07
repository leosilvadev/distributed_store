package br.leosilvadev.establishments.establishment.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.establishments.establishment.domains.Establishment
import br.leosilvadev.establishments.establishment.repositories.EstablishmentRepository

@Service
class EstablishmentFinder {

	@Autowired
	EstablishmentRepository establishmentRepository

	Optional<Establishment> find(String id) {
		Optional.ofNullable(establishmentRepository.findOne(id))
	}
}
