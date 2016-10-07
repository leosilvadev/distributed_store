package br.leosilvadev.products.establishment.clients.v1

import java.time.LocalDateTime

class Establishment {

	String id

	String name

	String email

	String documentNumber

	LocalDateTime registrationDatetime

	LocalDateTime lastUpdateDatetime

	Map config
}
