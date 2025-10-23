package org.ferggx.SpringProject.dto.mapping;


import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapping {
    UserDto toDto(User user);
    
}
