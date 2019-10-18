package com.uws.yl.service.impl;

import com.uws.yl.mapper.RolesMapper;
import com.uws.yl.model.Roles;
import com.uws.yl.model.Users;
import com.uws.yl.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yelu
 * @ClassName RolesServiceImpl
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/17 0017下午 2:58
 */
@Service("rolesServiceImpl")
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private RolesMapper rolesMapper;


    @Override
    public int insertRoles(Roles roles) {
        int rolesInt = rolesMapper.insertRoles(roles);
        Users users = new Users();
        users.setEmail("hello").setRoleId(roles.getId());
        return rolesMapper.insertUsers(users);
    }
}
