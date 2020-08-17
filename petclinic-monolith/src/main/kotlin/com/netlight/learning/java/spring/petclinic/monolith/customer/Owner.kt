package com.netlight.learning.java.spring.petclinic.monolith.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*
import javax.validation.constraints.Digits
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "owners")
data class Owner(
        @Id
        @GeneratedValue
        val id: Long,
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
        var telephone: String,
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
        var pets: MutableSet<Pet> = mutableSetOf()
)

@Repository
interface OwnerRepository: JpaRepository<Owner, Long>