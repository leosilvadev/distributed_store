package br.leosilvadev.products.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import br.leosilvadev.products.establishment.clients.v1.EstablishmentClient
import br.leosilvadev.products.product.domains.Product
import br.leosilvadev.products.product.repositories.ProductRepository
import br.leosilvadev.products.utils.React

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty

import rx.Observable

@Service
class ProductRegistrar {
	
	@Autowired
	ProductRepository productRepository
	
	@Autowired
	EstablishmentClient establishmentClient

	@HystrixCommand(groupKey='product-register',
		commandProperties = [
			@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
		]
	)
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
