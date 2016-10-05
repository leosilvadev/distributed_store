package br.leosilvadev.establishments.messaging.notifiers

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.establishments.domains.Establishment
import br.leosilvadev.establishments.messaging.config.MessagingConfig

@Service
class EstablishmentRegisteredNotifier {

	@Autowired
	RabbitTemplate rabbitTemplate

	def notify(Establishment establishment) {
		rabbitTemplate.convertAndSend(MessagingConfig.USER_REGISTRATION, '', establishment)
	}
}
