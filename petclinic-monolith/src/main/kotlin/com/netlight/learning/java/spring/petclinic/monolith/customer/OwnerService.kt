package com.netlight.learning.java.spring.petclinic.monolith.customer

import org.springframework.stereotype.Service

@Service
class OwnerService(val ownerRepository: OwnerRepository) {
    fun getOne(ownerId: Long): Owner = ownerRepository.getOne(ownerId)
}