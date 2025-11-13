package org.ferggx.SpringProject.dto.mapping;

import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstname());
        dto.setLastName(user.getLastname());
        dto.setUsername(user.getUsername());
        // остальные поля
        return dto;
    }

    public User toEntity(UserDto dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setFirstname(dto.getFirstName());
        user.setLastname(dto.getLastName());
        user.setUsername(dto.getUsername());
        // password, company, role, birthDate не трогаем (игнорируем)
        return user;
    }
}
