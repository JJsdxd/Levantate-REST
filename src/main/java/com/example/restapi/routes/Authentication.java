package com.example.restapi.routes;


import com.example.restapi.Secrets;
import com.example.restapi.pojos.LoginRequest;
import com.example.restapi.services.ChallengeService;
import com.example.restapi.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.restapi.entities.User;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController()
public class Authentication {
    @Autowired
    UserService userservice;

    @Autowired
    ChallengeService challengeService;


    @CrossOrigin()
    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, String>> UserRegistration( @RequestBody User newuser) {
        User create1 = new User();
        create1.setUsername(newuser.getUsername());
        create1.setEmail(newuser.getEmail());
        String hashedp = BCrypt.hashpw(newuser.getPassword(), BCrypt.gensalt(10));
        create1.setPassword(hashedp);
        User confirmed = userservice.CreateUser(create1);
        challengeService.challenge_init(confirmed.getId());

        return new ResponseEntity<>(JwtToken(confirmed), HttpStatus.OK);


    }

    @CrossOrigin()
    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, String>> UserLogin(@RequestBody LoginRequest logr) {
        User loguser = new User();
        loguser.setUsername(logr.username);
        loguser.setPassword(logr.password);
        User t1 = userservice.LoginUser(loguser);

        return new ResponseEntity<>(JwtToken(t1), HttpStatus.OK);

    }


    private Map<String, String> JwtToken(User user) {
        long current_time = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Secrets.API_KEY)
                .setIssuedAt(new Date(current_time))
                .setExpiration(new Date(current_time + Secrets.TOKEN_VALIDITY))
                .claim("user_id", user.getId())
                .claim("username", user.getUsername())
                .claim("email", user.getEmail())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;

    }


}
