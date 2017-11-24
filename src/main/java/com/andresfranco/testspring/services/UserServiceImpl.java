package com.andresfranco.testspring.services;

import com.andresfranco.testspring.commands.UserForm;
import com.andresfranco.testspring.converters.UserFormToUser;
import com.andresfranco.testspring.model.User;
import com.andresfranco.testspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserFormToUser userFormToUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserFormToUser userFormToUser) {
        this.userRepository = userRepository;
        this.userFormToUser = userFormToUser;
    }


    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User saveOrUpdateUserForm(UserForm userForm) {
        User savedUser = saveOrUpdate(userFormToUser.convert(userForm));

        System.out.println("Saved User Id: " + savedUser.getUserId());
        return savedUser;
    }
}