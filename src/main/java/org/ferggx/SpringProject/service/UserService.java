package org.ferggx.SpringProject.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.ferggx.SpringProject.dto.UserDto;
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
     private final UserMapping userMapping;


     public Optional<UserDto> findByFirstname (String firstname){
         var user = userRepository.findByFirstname(firstname).map(u->userMapping.toDto(u));
         user.isPresent();
         user.ifPresent(u->{
             System.out.println(u);});
         return Optional.ofNullable(user).orElseThrow(() -> new RuntimeException("Моё сообщение об ошибке")));
     }
}
