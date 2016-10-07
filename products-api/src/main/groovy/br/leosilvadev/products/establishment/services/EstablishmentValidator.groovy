package br.leosilvadev.products.establishment.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate

import br.leosilvadev.products.exceptions.InvalidEstablishmentException

@Service
class EstablishmentValidator {

	@Autowired
	Environment environment

	@Autowired
	RestTemplate restTemplate

	def validate(String establishmentId) {
		def url = environment.getProperty('apis.establishments.url')
		try {
			restTemplate.getForEntity("$url/v1/establishments/$establishmentId", Map)
		} catch (HttpClientErrorException ex) {
			throw new InvalidEstablishmentException()
		}
	}
}
