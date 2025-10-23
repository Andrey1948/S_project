package org.ferggx.SpringProject.dto.mapping;


import jakarta.persistence.*;
import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.entities.Company;
import org.ferggx.SpringProject.entities.Role;
import org.ferggx.SpringProject.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface UserMapping {
    UserDto toDto(User user);

    @InheritInverseConfiguration
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    User toEntity(UserDto dto);
}

