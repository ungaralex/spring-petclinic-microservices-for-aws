package com.netlight.learning.java.spring.petclinic.monolith.customer

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "pets")
data class Pet(
        @Id
        @GeneratedValue
        val id: Long,
        @NotBlank
        var name: String,
        @Temporal(TemporalType.DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        var birthDate: Date,
        @ManyToOne
        var type: PetType,
        @ManyToOne
        @JsonIgnoreProperties("pets")
        var owner: Owner
)

@Repository
interface PetRepository: JpaRepository<Pet, Long>