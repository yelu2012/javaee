package com.uws.yl.mapper;

import com.uws.yl.model.Roles;
import com.uws.yl.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesMapper {

    Roles getRoles(String id);

    int insertRoles(Roles roles);

    int insertUsers(Users users);
}
