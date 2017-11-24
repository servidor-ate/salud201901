
package com.andresfranco.testspring.services;
import com.andresfranco.testspring.commands.UserForm;
import com.andresfranco.testspring.model.User;
import java.util.List;

public interface UserService {
    List<User> listAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);

    User saveOrUpdateUserForm(UserForm userForm);
    
}
