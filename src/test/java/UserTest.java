import lombok.RequiredArgsConstructor;
import org.ferggx.SpringProject.ApplicationRunner;
import org.ferggx.SpringProject.entities.User;
import org.ferggx.SpringProject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Transactional
@SpringBootTest(classes = {ApplicationRunner.class})
@RequiredArgsConstructor
public class UserTest {

    private final UserRepository userRepository;

    @Test
    void test2() {
        var user = userRepository.findByFirstname("Ivan");
        System.out.println(user);
        assertTrue(user.isPresent());
    }
}
