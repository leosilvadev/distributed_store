package br.leosilvadev.products.contracts

import org.springframework.data.domain.Page

class PaginableResponse {

	final List items
	final Map paging
	
	PaginableResponse(Page page, Closure transformer=null) {
		if (transformer) {
			this.items = page.content.collect transformer
		} else {
			this.items = page.content
		}
		this.paging = [
			totalItems: page.totalElements,
			totalPages: page.totalPages,
			istLast: page.isLast(),
			page: page.number
		]
	}
	
	static PaginableResponse from(Page page, Closure transformer=null) {
		new PaginableResponse(page, transformer)
	}
}
