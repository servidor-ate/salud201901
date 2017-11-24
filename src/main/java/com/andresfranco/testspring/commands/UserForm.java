package com.andresfranco.testspring.commands;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;


public class UserForm {
    private Long userId;
    @Size(max = 20, min = 3)
    private String userName;
    @Email
    private String email;
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}
