package org.ferggx.SpringProject.repository;

import org.ferggx.SpringProject.entities.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository <Company, Integer> {

    Optional<Company> findByName(String name);

}
