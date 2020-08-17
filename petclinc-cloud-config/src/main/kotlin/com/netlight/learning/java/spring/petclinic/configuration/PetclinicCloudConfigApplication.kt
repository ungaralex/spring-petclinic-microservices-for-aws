package com.netlight.learning.java.spring.petclinic.configuration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetclinicCloudConfigApplication

fun main(args: Array<String>) {
	runApplication<PetclinicCloudConfigApplication>(*args)
}
