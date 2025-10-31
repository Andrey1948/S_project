import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.ferggx.SpringProject.ApplicationRunner;
import org.ferggx.SpringProject.entities.Company;
import org.ferggx.SpringProject.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // если используешь конструктор
//@ActiveProfiles("test") // чтобы брать application-test.yml
@Transactional
@SpringBootTest(classes = {ApplicationRunner.class})
@RequiredArgsConstructor
public class CompanyTest {

    private final CompanyRepository companyRepository;
    private final EntityManager entityManager;

    @Test
    public void test1() {
      var company = companyRepository.findByName("Google");
      assertTrue(company.isPresent());

    }
}


