package org.ferggx.SpringProject.dto.mapping;

import org.ferggx.SpringProject.dto.CompanyDto;
import org.ferggx.SpringProject.entities.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper {

    public CompanyDto toDto(Company company) {
        if (company == null) return null;

        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setName(company.getName());
        return dto;
    }

    public Company toEntity(CompanyDto dto) {
        if (dto == null) return null;

        Company entity = new Company();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}