package com.netlight.learning.java.spring.petclinic.monolith.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "pet_types")
data class PetType(
        @Id
        @GeneratedValue
        val id: Long,
        @NotBlank
        @Column(unique = true)
        var name: String
)

@Repository
interface PetTypeRepository: JpaRepository<PetType, Long>