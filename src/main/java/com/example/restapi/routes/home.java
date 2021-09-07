package com.example.restapi.routes;


import com.example.restapi.entities.User;
import com.example.restapi.repositories.UserRepository;
import com.example.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class home {


    @Autowired
    UserService userservice;

    @Autowired
    UserRepository userRepository;


    //Returns the user name and email from the jwt token
    @CrossOrigin
    @GetMapping("/dashboard")
    public Map<String, String> dash(HttpServletRequest request) {
        int token_user_id = (Integer) request.getAttribute("userId");
        User user = userRepository.findById(token_user_id);
        String user_name = user.getUsername();
        String user_email = user.getEmail();
        Map<String, String> map = new HashMap<>();
        map.put("username", user_name);
        map.put("email", user_email);
        return map;
    }


    // Rest Api status
    @GetMapping("/status")
    public ResponseEntity<String> Status() {
        return new ResponseEntity<>("Api Online", HttpStatus.OK);
    }


}
