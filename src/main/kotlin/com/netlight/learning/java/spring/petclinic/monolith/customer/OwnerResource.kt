package com.netlight.learning.java.spring.petclinic.monolith.customer

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("owners")
@RestController
class OwnerResource(val ownerRepository: OwnerRepository) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOwner(@Validated @RequestBody owner: Owner): Owner = ownerRepository.save(owner)

    @GetMapping("{ownerId}")
    fun findOwner(@PathVariable ownerId: Long): Optional<Owner> = ownerRepository.findById(ownerId)

    @GetMapping
    fun findAll(): List<Owner> = ownerRepository.findAll()
}