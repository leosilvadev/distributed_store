package br.leosilvadev

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class DiscoveryApiApplication {

	static void main(String[] args) {
		SpringApplication.run DiscoveryApiApplication, args
	}
}
