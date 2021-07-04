package com.adtech.ecommerce.service;

import com.adtech.ecommerce.repository.RoleRepository;
import com.adtech.ecommerce.security.model.ERole;
import com.adtech.ecommerce.security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitOperations {

    @Autowired
    RoleRepository roleRepository;

    public void createRoles() {
        List<Role> roles = Arrays.asList(new Role(ERole.ROLE_USER), new Role(ERole.ROLE_ADMIN));
        roleRepository.saveAll(roles);
    }
}
