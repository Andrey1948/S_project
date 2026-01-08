package org.ferggx.SpringProject.repository;

import org.ferggx.SpringProject.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>,
        FilterUserRepository, QuerydslPredicateExecutor<User> {

//    List<PersonalInfo> findAllByCompanyId(Integer companyId);
//    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);

//    @Query(value = "SELECT " +
//            "firstname, " +
//            "lastname, " +
//            "birth_date birthDate " +
//            "FROM users " +
//            "WHERE company_id = :companyId",
//            nativeQuery = true)
//   List<IPersonalInfo> findAllByCompanyId(Integer companyId);


    //List<User> findFirst4By(Sort sort);

    Page<User> findFirst4By(Pageable pageable);

}