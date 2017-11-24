package com.andresfranco.testspring.converters;

import com.andresfranco.testspring.commands.UserForm;
import com.andresfranco.testspring.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class UserToUserForm implements Converter<User,UserForm> {
    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setUserId(user.getUserId());
        userForm.setUserName(user.getUserName());
        userForm.setPassword(user.getPassword());
        userForm.setEmail(user.getEmail());
        return userForm;
    }
}
