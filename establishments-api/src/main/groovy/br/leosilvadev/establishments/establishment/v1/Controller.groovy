package br.leosilvadev.establishments.establishment.v1

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import br.leosilvadev.establishments.establishment.repositories.EstablishmentRepository
import br.leosilvadev.establishments.establishment.services.EstablishmentRegistrar

@RestController
@RequestMapping('/v1/establishments')
class Controller {

	@Autowired
	EstablishmentRepository establishmentRepository

	@Autowired
	EstablishmentRegistrar establishmentRegistrar

	@RequestMapping(method=RequestMethod.POST)
	def register(@RequestBody @Valid RegistrationRequest request) {
		def establishment = request.toDomain()
		establishmentRegistrar.register establishment
		ResponseEntity.created(linkTo(Controller).slash(establishment.id).toUri()).build()
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	def get(@PathVariable String id) {
		ResponseEntity.ok(establishmentRepository.findOne(id))
	}
}
