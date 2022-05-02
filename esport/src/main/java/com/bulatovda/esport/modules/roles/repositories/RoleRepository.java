package com.bulatovda.esport.modules.roles.repositories;

import com.bulatovda.esport.modules.roles.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RoleRepository  extends CrudRepository<RoleEntity, Long> {
	Optional<RoleEntity> findByName(String name);
}
