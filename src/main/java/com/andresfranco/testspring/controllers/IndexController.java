/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andresfranco.testspring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.andresfranco.testspring.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.andresfranco.testspring.model.User;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class IndexController {
    @RequestMapping("/")
    public String getUsers(Model model) {

        model.addAttribute("title","Index title");
      
        return "index/index";
    }
}
