package com.bulatovda.esport.modules.roles.repositories;

import com.bulatovda.esport.modules.roles.entities.UserRoleEntity;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {
}
