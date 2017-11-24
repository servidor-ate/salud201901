package com.andresfranco.testspring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.andresfranco.testspring.model.User;
import com.andresfranco.testspring.commands.UserForm;
import com.andresfranco.testspring.converters.UserToUserForm;
import com.andresfranco.testspring.services.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.andresfranco.testspring.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UserController extends GeneralController {

    private UserService userService;
    private UserToUserForm userToUserForm;
  

     @Autowired
    public void setUserToUserForm(UserToUserForm userToUserForm) {
        this.userToUserForm = userToUserForm;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
  

    @RequestMapping("/users")
    public String getUsers(Model model) {

        model.addAttribute("users", userService.listAll());
        model.addAttribute("showRoute", this.setRoute("users", "show", ""));
        model.addAttribute("editRoute", this.setRoute("users", "edit", ""));
        model.addAttribute("newRoute", this.setRoute("users", "new", ""));
        model.addAttribute("deleteRoute", this.setRoute("users", "delete", ""));
        return "users/index";
    }

    @RequestMapping("/users/show/{userId}")
    public String ShowUser(@PathVariable String userId, Model model) {

        model.addAttribute("user", userService.getById(new Long(userId)));
        model.addAttribute("indexRoute", this.setRoute("users", "index", ""));
        model.addAttribute("title", "User Details"); 
        return "users/show";
    }

    @RequestMapping("/users/edit/{userId}")
    public String EditUser(@PathVariable String userId, Model model) {
        
        User user = userService.getById(Long.valueOf(userId));
        UserForm userForm = userToUserForm.convert(user);
        model.addAttribute("userForm", userForm);
         model.addAttribute("title", "Edit User");
        model.addAttribute("indexRoute", this.setRoute("users", "index", ""));
        
        return "users/userform";
    }
    
     @RequestMapping("/users/new")
    public String NewUser(Model model) {
        
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("title", "New User");
        model.addAttribute("indexRoute", this.setRoute("users", "index", ""));
         
        return "users/userform";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid UserForm userForm, BindingResult bindingResult,Model model){
         
        if(bindingResult.hasErrors()){
             model.addAttribute("indexRoute", this.setRoute("users", "index", ""));

            return "users/userform";
        }

        User savedUser = userService.saveOrUpdateUserForm(userForm);
         
        return "redirect:/users/show/" + savedUser.getUserId();
        
//            bindingResult.getAllErrors().forEach(objectError -> {
//                System.out.println(objectError.toString());
//            });
    }
    
    
    @RequestMapping(value="users/delete/{userId}", method = RequestMethod.DELETE)
    public String DeleteUser(@PathVariable String userId) {
     
        userService.delete(new Long(userId));
        return "redirect:"+this.setRoute("users", "index", "");
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        //log.error("Handling not found exception");
        //log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
    
    
}
