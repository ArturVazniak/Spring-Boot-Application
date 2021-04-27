package com.artur.Controller;

import com.artur.domain.Role;
import com.artur.domain.User;
import com.artur.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UserRepo userRepo;

    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){

       User useFromDb = userRepo.findByUsername(user.getUsername());

       if(useFromDb != null){
           model.put("message","User exists!");
           return "registration";
       }

       user.setActive(true);
       user.setRole(Collections.singleton(Role.USER));
       userRepo.save(user);
        return "redirect:/login";
    }
}
