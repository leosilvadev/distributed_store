package br.leosilvadev.establishments

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class Application {

	static void main(args) {
		SpringApplication.run Application, args
	}
}
