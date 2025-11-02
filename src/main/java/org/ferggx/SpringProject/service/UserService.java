package org.ferggx.SpringProject.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.dto.mapping.UserMapper;
import org.ferggx.SpringProject.dto.mapping.UserMapping;
import org.ferggx.SpringProject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@ToString
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public Optional<UserDto> findByFirstname(String firstname) {
        var user = userRepository.findByFirstname(firstname).map(u -> userMapper.toDto(u))
                .map(u -> {
                    System.out.println(u);
                    return u;})
        .orElseThrow(() -> new RuntimeException("Моё сообщение об ошибке"));
        return Optional.empty();
    }
}
