package br.leosilvadev.products.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.products.product.domains.Product
import br.leosilvadev.products.product.repositories.ProductRepository

@Service
class ProductRegistrar {

	@Autowired
	ProductRepository productRepository

	def register(Product product) {
		productRepository.save product
	}
}
