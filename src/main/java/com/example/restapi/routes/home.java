package com.example.restapi.routes;


import com.example.restapi.entities.User;
import com.example.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class home {


    @Autowired
    UserService userservice;


    @GetMapping("/home")
     public List<User> getuser(){
        return userservice.getUsers();
       }


}
