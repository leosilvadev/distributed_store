package br.leosilvadev.products.repositories;

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import br.leosilvadev.products.domains.Product

@Repository
interface ProductRepository extends MongoRepository<Product, String> {

}
