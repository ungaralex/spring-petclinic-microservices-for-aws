package com.netlight.learning.java.spring.petclinic.monolith

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class MonolithApplication

fun main(args: Array<String>) {
	runApplication<MonolithApplication>(*args)
}
