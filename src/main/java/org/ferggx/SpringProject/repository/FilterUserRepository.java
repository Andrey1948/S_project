package org.ferggx.SpringProject.repository;

import org.ferggx.SpringProject.dto.UserFilter;
import org.ferggx.SpringProject.entities.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}
