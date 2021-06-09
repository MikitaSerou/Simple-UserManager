package com.example.task4itr.repository;

import com.example.task4itr.enums.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Byte> {

    Role findByName(String roleName);
}
