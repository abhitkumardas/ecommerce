package com.adtech.ecommerce.repository;

import com.adtech.ecommerce.security.model.ERole;
import com.adtech.ecommerce.security.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
