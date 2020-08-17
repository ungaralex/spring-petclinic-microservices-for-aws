package com.netlight.learning.java.spring.petclinic.configuration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class PetclinicCloudConfigApplication

fun main(args: Array<String>) {
	runApplication<PetclinicCloudConfigApplication>(*args)
}
