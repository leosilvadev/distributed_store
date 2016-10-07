package br.leosilvadev.products.product.v1

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import br.leosilvadev.products.product.services.ProductFinder
import br.leosilvadev.products.product.services.ProductRegistrar

@RestController
@RequestMapping("/v1/products")
class Controller {

	@Autowired
	ProductRegistrar productRegistrar

	@Autowired
	ProductFinder productFinder

	@RequestMapping(method=RequestMethod.GET)
	def list(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="10") Integer itemsPerPage) {
		ResponseEntity.ok(productFinder.findAll(page, itemsPerPage))
	}

	@RequestMapping(method=RequestMethod.POST)
	def register(@RequestHeader(value="X-Establishment-Id") String establishmentId, @RequestBody @Valid RegistrationRequest request) {
		def product = request.toDomain(establishmentId)
		productRegistrar.register product
		ResponseEntity.created(linkTo(Controller).slash(product.id).toUri()).build()
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	def get(@PathVariable String id) {
		ResponseEntity.ok(productFinder.find(id))
	}
}
