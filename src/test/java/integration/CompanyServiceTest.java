package integration;

import org.ferggx.SpringProject.ApplicationRunner;
import org.ferggx.SpringProject.dto.CompanyDto;
import org.ferggx.SpringProject.dto.CompanyReadDto;
import org.ferggx.SpringProject.dto.mapping.CompanyMapper;
import org.ferggx.SpringProject.entities.Company;
import org.ferggx.SpringProject.repository.CompanyRepository;
import org.ferggx.SpringProject.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@Transactional
class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private CompanyMapper mapper;

    @InjectMocks
    private CompanyService companyService;

    @Test
    void findByName_shouldReturnCompanyDto() {
        var company = new Company();
        company.setName("TestCo");

        var dto = new CompanyDto();
        dto.setName("TestCo");

        when(companyRepository.findByName("TestCo"))
                .thenReturn(Optional.of(company));
        when(mapper.toDto(company))
                .thenReturn(dto);

        var result = companyService.findByName("TestCo");

        assertTrue(result.isPresent());
        assertEquals("TestCo", result.get().getName());
        verify(companyRepository).findByName("TestCo");
    }

//unit with Mock
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

