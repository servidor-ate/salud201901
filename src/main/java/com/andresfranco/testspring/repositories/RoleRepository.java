package com.andresfranco.testspring.repositories;
import org.springframework.data.repository.CrudRepository;
import com.andresfranco.testspring.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
}
