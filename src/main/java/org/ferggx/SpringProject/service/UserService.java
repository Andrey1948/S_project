package org.ferggx.SpringProject.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.ferggx.SpringProject.dto.UserCreateEditDto;
import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.dto.UserReadDto;
import org.ferggx.SpringProject.dto.mapping.UserCreateEditMapper;
import org.ferggx.SpringProject.dto.mapping.UserMapper;
import org.ferggx.SpringProject.dto.mapping.UserMapping;
import org.ferggx.SpringProject.dto.mapping.UserReadMapper;
import org.ferggx.SpringProject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@ToString
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserMapper userMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }


    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }

    public Optional<UserDto> findByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname)
                .map(userMapper::toDto) // конвертируем User → UserDto
                .map(dto -> {
                    System.out.println(dto); // просто отладка
                    return dto;
                });
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                       userRepository.flush();
                    return true;
                })
                .orElse(false);
    }


}