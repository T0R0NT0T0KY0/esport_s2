package com.bulatovda.esport.modules.roles.services;

import com.bulatovda.esport.modules.roles.entities.UserRoleEntity;
import com.bulatovda.esport.modules.roles.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleService {
	UserRoleEntity addRoleToUser(long userId, UserRoleEnum role);
}
