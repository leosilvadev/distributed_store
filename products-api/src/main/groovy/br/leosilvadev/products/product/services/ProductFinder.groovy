package br.leosilvadev.products.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

import br.leosilvadev.products.product.domains.Product
import br.leosilvadev.products.product.repositories.ProductRepository

@Service
class ProductFinder {

	@Autowired
	ProductRepository productRepository

	Product find(String id) {
		productRepository.findOne id
	}
	
	Page findAll(Integer page, Integer itemsPerPage) {
		def pageRequest = new PageRequest(page-1, itemsPerPage)
		productRepository.findAll pageRequest
	}
}
