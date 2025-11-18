package org.ferggx.SpringProject.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.ferggx.SpringProject.entities.Role;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;


}
