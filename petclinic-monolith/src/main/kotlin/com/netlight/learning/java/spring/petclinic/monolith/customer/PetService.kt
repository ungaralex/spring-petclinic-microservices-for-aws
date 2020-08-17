package com.netlight.learning.java.spring.petclinic.monolith.customer

import org.springframework.stereotype.Service

@Service
class PetService(
        val petRepository: PetRepository,
        val petTypeRepository: PetTypeRepository
) {
    fun addPetType(type: PetType): PetType = petTypeRepository.save(type)

    fun getPetTypeById(typeId: Long): PetType = petTypeRepository.getOne(typeId)

    fun getAllTypes(): List<PetType> = petTypeRepository.findAll()

    fun addPet(pet: Pet): Pet = petRepository.save(pet)

    fun getPetById(petId: Long): Pet = petRepository.getOne(petId)

    fun updatePet(pet: Pet, petTypeId: Long) {
        val petType = if (petTypeId != pet.type.id) petTypeRepository.getOne(petTypeId) else pet.type
        pet.type = petType
        petRepository.save(pet)
    }

    fun getAllPets(): List<Pet> = petRepository.findAll()
}