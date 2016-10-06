package br.leosilvadev.users.messaging.consumers

import groovy.json.JsonSlurper

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import br.leosilvadev.users.domains.EstablishmentUser
import br.leosilvadev.users.repositories.EstablishmentUserRepository

@Component
class UserRegistrationConsumer implements MessageListener {

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
