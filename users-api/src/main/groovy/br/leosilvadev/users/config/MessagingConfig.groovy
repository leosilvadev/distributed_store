package br.leosilvadev.users.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import br.leosilvadev.users.establishment_user.services.EstablishmentUserRegistrationConsumer;

@Configuration
class MessagingConfig {

	@Autowired
	EstablishmentUserRegistrationConsumer userRegistrationConsumer
	
	@Bean
	Queue queueRegisterUser() {
		new Queue('queue.establishment_user.register')
	}

	@Bean
	SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer()
		container.setConnectionFactory(connectionFactory)
		container.setQueues(queueRegisterUser())
		container.setMessageListener(userRegistrationConsumer)
		container
	}
}
