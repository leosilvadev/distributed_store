package br.leosilvadev.products.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.products.establishment.services.EstablishmentValidator
import br.leosilvadev.products.product.domains.Product
import br.leosilvadev.products.product.repositories.ProductRepository

@Service
class ProductRegistrar {
	
	@Autowired
	ProductRepository productRepository
	
	@Autowired
	EstablishmentValidator establishmentValidator

	def register(Product product) {
		(validate >> save)(product)
	}
	
	private validate = { product ->
		establishmentValidator.validate(product.establishmentId)
		product
	}
	
	private save = { product ->
		productRepository.save product
		product
	}
}
