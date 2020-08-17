package com.netlight.learning.java.spring.petclinic.monolith.customer

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.constraints.Digits
import javax.validation.constraints.NotBlank

@RequestMapping("owners")
@RestController
class OwnerResource(val ownerRepository: OwnerRepository, val ownerMapper: OwnerMapper) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOwner(@Validated @RequestBody owner: Owner): Owner = ownerRepository.save(owner)

    @GetMapping("{ownerId}")
    fun findOwner(@PathVariable ownerId: Long): Optional<Owner> = ownerRepository.findById(ownerId)

    @GetMapping
    fun findAll(): List<Owner> = ownerRepository.findAll()

    @PutMapping("{ownerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateOwner(@PathVariable ownerId: Long, @RequestBody ownerUpdate: OwnerUpdate) {
        ownerRepository.getOne(ownerId).also {
            ownerMapper.updateOwner(it, ownerUpdate)
            ownerRepository.save(it)
        }
    }
}

data class OwnerUpdate(
        @NotBlank
        var firstName: String,
        @NotBlank
        var lastName: String,
        @NotBlank
        var address: String,
        @NotBlank
        var city: String,
        @NotBlank
        @Digits(fraction = 0, integer = 10)
        var telephone: String
)