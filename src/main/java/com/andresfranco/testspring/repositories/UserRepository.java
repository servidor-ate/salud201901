package com.andresfranco.testspring.repositories;
import org.springframework.data.repository.CrudRepository;
import com.andresfranco.testspring.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}