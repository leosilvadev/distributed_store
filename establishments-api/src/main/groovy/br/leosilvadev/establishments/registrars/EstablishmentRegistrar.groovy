package br.leosilvadev.establishments.registrars

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.establishments.domains.Establishment
import br.leosilvadev.establishments.messaging.notifiers.EstablishmentRegisteredNotifier
import br.leosilvadev.establishments.repositories.EstablishmentRepository

@Service
class EstablishmentRegistrar {

	@Autowired
	EstablishmentRepository establishmentRepository

	@Autowired
	EstablishmentRegisteredNotifier establishmentRegisteredNotifier

	def register(Establishment establishment) {
		(save >> notify)(establishment)
	}
	
	private save = { Establishment establishment ->
		establishmentRepository.save establishment
		establishment
	}
	
	private notify = { Establishment establishment ->
		establishmentRegisteredNotifier.notify establishment
		establishment
	}
}
