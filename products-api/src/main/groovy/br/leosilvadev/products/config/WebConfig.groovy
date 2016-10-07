package br.leosilvadev.products.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class WebConfig {

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		builder.build()
	}
}
