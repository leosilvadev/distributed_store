package br.leosilvadev.products.product.repositories;

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.products.product.domains.Product

@Repository
interface ProductRepository extends MongoRepository<Product, String> {
}
