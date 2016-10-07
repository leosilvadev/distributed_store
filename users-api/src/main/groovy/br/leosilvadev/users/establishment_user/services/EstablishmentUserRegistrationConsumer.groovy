package br.leosilvadev.users.establishment_user.services

import groovy.json.JsonSlurper

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import br.leosilvadev.users.establishment_user.domains.EstablishmentUser
import br.leosilvadev.users.establishment_user.repositories.EstablishmentUserRepository;

@Component
class EstablishmentUserRegistrationConsumer implements MessageListener {

	@Autowired
	EstablishmentUserRepository establishmentUserRepository
	
	void onMessage(Message message) {
		def event = eventOf message
		def user = new EstablishmentUser(event.email)
		establishmentUserRepository.save user
	}
	
	private eventOf(message) {
		new JsonSlurper().parse message.body
	}
}
