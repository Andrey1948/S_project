package org.ferggx.SpringProject.service;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.ferggx.SpringProject.dto.CompanyDto;
import org.ferggx.SpringProject.dto.mapping.CompanyMapper;
import org.ferggx.SpringProject.dto.mapping.CompanyMapping;
import org.ferggx.SpringProject.repository.CompanyRepository;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@ToString
@Service
@Transactional
public class CompanyService {


    private final CompanyRepository companyRepository;
    private final CompanyMapper mapper;

    public Optional<CompanyDto> findByName(String name) {
        var cc = companyRepository.findByName(name)
                .map(c -> mapper.toDto(c));
        cc.ifPresent(c -> System.out.println(c.getName()));
        return cc;
    }

}


