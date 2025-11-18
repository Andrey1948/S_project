import lombok.RequiredArgsConstructor;
import org.ferggx.SpringProject.ApplicationRunner;
import org.ferggx.SpringProject.dto.UserCreateEditDto;
import org.ferggx.SpringProject.dto.UserReadDto;
import org.ferggx.SpringProject.dto.mapping.UserMapping;
import org.ferggx.SpringProject.entities.Role;
import org.ferggx.SpringProject.entities.User;
import org.ferggx.SpringProject.repository.UserRepository;
import org.ferggx.SpringProject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest(classes = {ApplicationRunner.class})
@RequiredArgsConstructor
//@DataJpaTest
public class UserTest {

    private final UserRepository userRepository;
    private final UserService userService;


//Service.
    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> result = userService.findById(1L);
        assertTrue(result.isPresent());
        result.ifPresent(userReadDto -> assertThat(userReadDto.getId()).isEqualTo(1L));
    }

    @Test
    void create() {
        UserCreateEditDto userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                1
        );
        UserReadDto actualResult = userService.create(userDto);

        assertEquals(userDto.getUsername(), actualResult.getUsername());
        assertEquals(userDto.getBirthDate(), actualResult.getBirthDate());
        assertEquals(userDto.getFirstname(), actualResult.getFirstname());
        assertEquals(userDto.getLastname(), actualResult.getLastname());
        assertEquals(userDto.getCompanyId(), actualResult.getCompany().id());
        assertSame(userDto.getRole(), actualResult.getRole());
    }

    @Test
    void update() {
        UserCreateEditDto userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                1
        );
        Optional<UserReadDto> actualResult = userService.update(1L, userDto);
        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> {
            assertEquals(userDto.getUsername(), user.getUsername());
            assertEquals(userDto.getBirthDate(), user.getBirthDate());
            assertEquals(userDto.getFirstname(), user.getFirstname());
            assertEquals(userDto.getLastname(), user.getLastname());
            assertEquals(userDto.getCompanyId(), user.getCompany().id());
            assertSame(userDto.getRole(), user.getRole());
        });
    }

    @Test
    void delete() {
        assertFalse(userService.delete(-124L));
        assertTrue(userService.delete(1L));
    }

    @Test
    void test2() {
        var user = userRepository.findByFirstname("Ivan");
        System.out.println(user);
        assertTrue(user.isPresent());
    }
}
