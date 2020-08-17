package com.netlight.learning.java.spring.petclinic.monolith.customer;

import com.netlight.learning.java.spring.petclinic.monolith.config.ConstantsKt;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ConstantsKt.MAPPER_SPRING_COMPONENT_MODEL)
public interface OwnerMapper {
    Owner updateOwner(@MappingTarget final Owner toBeUpdated, final OwnerUpdate update);
}