package br.leosilvadev.products.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import rx.Observable
import br.leosilvadev.products.establishment.clients.v1.EstablishmentClient
import br.leosilvadev.products.product.domains.Product
import br.leosilvadev.products.product.repositories.ProductRepository
import br.leosilvadev.products.utils.React

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand


@Service
class ProductRegistrar {
	
	@Autowired
	ProductRepository productRepository
	
	@Autowired
	EstablishmentClient establishmentClient

	@HystrixCommand
	Observable<Product> register(Product product) {
		React.when {
			(validate >> save)(product)
		}
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
