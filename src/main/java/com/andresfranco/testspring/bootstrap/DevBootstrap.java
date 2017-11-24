package com.andresfranco.testspring.bootstrap;

import com.andresfranco.testspring.model.User;
import com.andresfranco.testspring.model.Role;
import com.andresfranco.testspring.repositories.RoleRepository;
import com.andresfranco.testspring.repositories.UserRepository;
import java.util.HashSet;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public DevBootstrap(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
       
//       User user = new User("afranco", "koloinotzente@gmail.com","password1");
//       Role role = new Role("admin","administrator");
//       user.getUserRoles().add(role);
//       role.getUsers().add(user);
//       userRepository.save(user);
//       roleRepository.save(role);
       
       
       
       
       
      
       
    }
}
