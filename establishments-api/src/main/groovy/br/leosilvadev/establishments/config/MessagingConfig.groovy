package br.leosilvadev.establishments.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import br.leosilvadev.establishments.constants.Messaging

@Configuration
class MessagingConfig {
		
	@Bean
	Queue queueRegisterConfig() {
		new Queue('queue.establishment_config.register')
	}
	
	@Bean
	Queue queueRegisterUser() {
		new Queue('queue.establishment_user.register')
	}
	
	@Bean
	FanoutExchange fanout() {
		new FanoutExchange(Messaging.USER_REGISTRATION)
	}

	@Bean
	Binding bindingConfigRegister() {
		BindingBuilder.bind(queueRegisterConfig()).to(fanout())
	}

	@Bean
	Binding bindingUserRegister() {
		BindingBuilder.bind(queueRegisterUser()).to(fanout())
	}
}
