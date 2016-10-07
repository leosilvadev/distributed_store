package br.leosilvadev.plans.type.v1

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import br.leosilvadev.plans.type.services.PlanTypeFinder
import br.leosilvadev.plans.type.services.PlanTypeRegistrar

@RestController
@RequestMapping('/v1/plans/types')
class Controller {

	@Autowired
	PlanTypeRegistrar planTypeRegistrar

	@Autowired
	PlanTypeFinder planTypeFinder

	@RequestMapping(method=RequestMethod.POST)
	def register(@RequestBody @Valid RegistrationRequest request) {
		def type = request.toDomain()
		planTypeRegistrar.register type
		ResponseEntity.created(linkTo(Controller).slash(type.id).toUri()).build()
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	def get(@PathVariable String id) {
		ResponseEntity.ok(planTypeFinder.find(id))
	}
}
