package br.leosilvadev.establishments.establishment.services

import groovy.json.JsonOutput

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.establishments.constants.Messaging
import br.leosilvadev.establishments.establishment.domains.Establishment

@Service
class EstablishmentRegisteredNotifier {

	@Autowired
	RabbitTemplate rabbitTemplate

	def notify(Establishment establishment) {
		def event = eventOf establishment
		rabbitTemplate.convertAndSend(Messaging.USER_REGISTRATION, '', event)
	}

	private eventOf(Establishment e) {
		JsonOutput.toJson([id: e.id, name: e.name, email: e.email, documentNumber: e.documentNumber])
	}
}
