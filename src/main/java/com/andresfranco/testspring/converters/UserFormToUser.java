package com.andresfranco.testspring.converters;

import com.andresfranco.testspring.commands.UserForm;
import com.andresfranco.testspring.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class UserFormToUser implements Converter<UserForm, User> {

    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        if (userForm.getUserId() != null  && !StringUtils.isEmpty(userForm.getUserId())) {
            user.setUserId(new Long(userForm.getUserId()));
        }
        user.setEmail(userForm.getEmail());
        user.setUserName(userForm.getUserName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
     
        return user;
    }
}
