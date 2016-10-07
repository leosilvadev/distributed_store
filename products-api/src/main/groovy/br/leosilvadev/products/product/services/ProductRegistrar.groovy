package br.leosilvadev.products.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.products.establishment.clients.v1.EstablishmentClient
import br.leosilvadev.products.product.domains.Product
import br.leosilvadev.products.product.repositories.ProductRepository

@Service
class ProductRegistrar {
	
	@Autowired
	ProductRepository productRepository
	
	@Autowired
	EstablishmentClient establishmentClient

	def register(Product product) {
		(validate >> save)(product)
	}
	
	private validate = {
		establishmentClient.find(it.establishmentId)
		it
	}
	
	private save = {
		productRepository.save it
		it
	}
}
