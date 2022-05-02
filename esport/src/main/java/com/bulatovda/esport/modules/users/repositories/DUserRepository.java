package com.bulatovda.esport.modules.users.repositories;

import com.bulatovda.esport.modules.users.entities.DUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DUserRepository  extends CrudRepository<DUserEntity, Long> {
}
