package org.ferggx.SpringProject.dto.mapping;

import org.ferggx.SpringProject.dto.CompanyDto;
import org.ferggx.SpringProject.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapping {

    CompanyDto toDto(Company company);

    @Mapping(target = "locales", ignore = true)
    Company toEntity(CompanyDto companyDto);

}
