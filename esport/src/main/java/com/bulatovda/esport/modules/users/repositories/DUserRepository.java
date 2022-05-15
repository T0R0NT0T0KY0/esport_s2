package com.bulatovda.esport.modules.users.repositories;

import com.bulatovda.esport.modules.users.entities.DUserEntity;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DUserRepository  extends CrudRepository<DUserEntity, Long> {
	Optional<DUserEntity> findByUserId(long userId);
}
