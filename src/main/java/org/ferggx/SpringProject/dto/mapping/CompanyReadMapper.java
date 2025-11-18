package org.ferggx.SpringProject.dto.mapping;

import org.ferggx.SpringProject.dto.CompanyReadDto;
import org.ferggx.SpringProject.entities.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto map(Company company) {
        return new CompanyReadDto(
                company.getId(),
                company.getName()
        );
    }
}