package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import com.example.demo.entity.enums.RoleName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
    UserRole getUserRoleById(Long id);
    @Query("SELECT ur FROM UserRole ur WHERE ur.roleName= :roleName")
    UserRole getUserRoleByName(RoleName roleName);

}
