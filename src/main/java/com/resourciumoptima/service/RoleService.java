package com.resourciumoptima.service;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.domain.Role;
import com.resourciumoptima.repository.RoleRepository;

public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void assignRoleToUser(Employee user, Role role) {
    }


}

