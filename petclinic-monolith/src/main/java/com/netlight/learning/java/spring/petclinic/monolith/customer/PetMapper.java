package com.netlight.learning.java.spring.petclinic.monolith.customer;

import com.netlight.learning.java.spring.petclinic.monolith.config.ConstantsKt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ConstantsKt.MAPPER_SPRING_COMPONENT_MODEL)
public interface PetMapper {
    Pet updatePet(@MappingTarget final Pet toBeUpdated, final PetUpdateDTO update);
    @Mapping(target = "name", source = "pet.name")
    Pet from(final NewPetDTO pet, final Owner owner, final PetType type);
}
