package br.leosilvadev.establishments.messaging.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessagingConfig {
	
	final static String USER_REGISTRATION = "fanout.establishments.registered"
	
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
		new FanoutExchange(USER_REGISTRATION)
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
