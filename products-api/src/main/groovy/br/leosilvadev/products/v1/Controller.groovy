package br.leosilvadev.products.v1

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import br.leosilvadev.products.contracts.PaginableResponse
import br.leosilvadev.products.domains.Product
import br.leosilvadev.products.repositories.ProductRepository

@RestController
@RequestMapping("/v1/products")
class Controller {

	@Autowired
	ProductRepository productRepository

	@RequestMapping(method=RequestMethod.GET)
	def list(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="10") Integer size) {
		def pageRequest = new PageRequest(page-1, size)
		ResponseEntity.ok(PaginableResponse.from(productRepository.findAll(pageRequest)))
	}

	@RequestMapping(method=RequestMethod.POST)
	def register(@RequestBody @Valid RegistrationRequest request) {
		Product product = request.toDomain()
		productRepository.save(product)
		ResponseEntity.created(linkTo(Controller).slash(product.id).toUri()).build()
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	def get(@PathVariable String id) {
		ResponseEntity.ok(productRepository.findOne(id))
	}
}
