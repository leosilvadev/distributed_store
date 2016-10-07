package br.leosilvadev.products.establishment.clients.v1

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient('establishments-api')
interface EstablishmentClient {

	@RequestMapping(method=RequestMethod.GET, value='/v1/establishments/{id}')
	Establishment find(@PathVariable('id') String id)
}
