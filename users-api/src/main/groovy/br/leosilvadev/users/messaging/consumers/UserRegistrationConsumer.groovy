package br.leosilvadev.users.messaging.consumers

import groovy.json.JsonSlurper

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener

class UserRegistrationConsumer implements MessageListener {

	void onMessage(Message message) {
		def event = eventOf message
		println event
	}
	
	private eventOf(message) {
		new JsonSlurper().parse message.body
	}
}
