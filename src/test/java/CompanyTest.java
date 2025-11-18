import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.ferggx.SpringProject.ApplicationRunner;
import org.ferggx.SpringProject.dto.CompanyReadDto;
import org.ferggx.SpringProject.dto.mapping.CompanyMapping;
import org.ferggx.SpringProject.entities.Company;
import org.ferggx.SpringProject.repository.CompanyRepository;
import org.ferggx.SpringProject.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;


// если используешь конструктор
//@ActiveProfiles("test") // чтобы брать application-test.yml
@Transactional
@SpringBootTest(classes = {ApplicationRunner.class})
@RequiredArgsConstructor
public class CompanyTest {

    private final CompanyRepository companyRepository;
    private CompanyService companyService;

    @Test
    public void test1() {
        var company = companyRepository.findByName("Google");
        assertTrue(company.isPresent());
    }

    @Test
    void findById() {
        Mockito.doReturn(Optional.of(new Company(2, null, Collections.emptyMap())))
                .when(companyRepository).findById(2);
        var actualResult = companyService.findById(2);

        assertTrue(actualResult.isPresent());
        var expectedResult = new CompanyReadDto(2, null);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}


