package com.netlight.learning.java.spring.petclinic.monolith.customer

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonView
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
        var telephone: String
) {
        // Break circular dependency for auto generated methods
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
        @JsonIgnoreProperties("owner")
        var pets: MutableSet<Pet> = mutableSetOf()
}

@Repository
interface OwnerRepository: JpaRepository<Owner, Long>