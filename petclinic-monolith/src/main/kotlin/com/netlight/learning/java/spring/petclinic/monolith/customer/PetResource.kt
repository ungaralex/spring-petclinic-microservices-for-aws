package com.netlight.learning.java.spring.petclinic.monolith.customer

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.validation.constraints.NotBlank

@RestController
class PetResource(val petService: PetService, val ownerService: OwnerService, val petMapper: PetMapper) {
    @PostMapping("pets/types")
    fun addPetType(@RequestParam name: String): PetType {
        return with(PetType(0, name)) {
            petService.addPetType(this)
        }
    }

    @GetMapping("pets/types")
    fun getPetTypes(): List<PetType> = petService.getAllTypes()

    @PostMapping("owners/{ownerId}/pets")
    fun addPet(@PathVariable ownerId: Long, @RequestBody @Validated newPetDTO: NewPetDTO): Pet {
        val petType = petService.getPetTypeById(newPetDTO.petTypeId)
        val owner = ownerService.getOne(ownerId)
        val pet = petMapper.from(newPetDTO, owner, petType)

        return petService.addPet(pet)
    }

    @PutMapping("pets/{petId}")
    fun updatePet(@PathVariable petId: Long, @RequestBody @Validated updateDTO: PetUpdateDTO) {
        with(petService.getPetById(petId)) { petService.updatePet(this, updateDTO.petTypeId) }
    }

    @GetMapping("pets/{petId}")
    fun findPet(@PathVariable petId: Long): Pet = petService.getPetById(petId)

    @GetMapping("pets")
    fun getAllPets(): List<Pet> = petService.getAllPets()
}

data class PetUpdateDTO(
        @NotBlank
        var name: String,
        @Temporal(TemporalType.DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        var birthDate: Date,
        var petTypeId: Long
)

data class NewPetDTO(
        @NotBlank
        var name: String,
        @Temporal(TemporalType.DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        var birthDate: Date,
        var petTypeId: Long
)