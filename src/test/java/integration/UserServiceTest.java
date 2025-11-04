package integration;

import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.dto.mapping.UserMapper;
import org.ferggx.SpringProject.entities.User;
import org.ferggx.SpringProject.repository.UserRepository;
import org.ferggx.SpringProject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Transactional
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    public void findByFirstName() {
        User user = new User();
        user.setFirstname("Tito");

        UserDto userDto = new UserDto();
        userDto.setFirstName("Tito");

        when(userRepository.findByFirstname("Tito"))
                .thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(userDto);

        var result = userService.findByFirstname("Tito");

        assertTrue(result.isPresent());
        assertEquals("Tito", result.get().getFirstName());
        verify(userRepository).findByFirstname("Tito");

    }
}
