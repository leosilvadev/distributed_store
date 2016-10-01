package br.leosilvadev

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
class ProductsApiApplication {

	static void main(String[] args) {
		SpringApplication.run ProductsApiApplication, args
	}
}
