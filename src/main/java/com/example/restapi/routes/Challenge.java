package com.example.restapi.routes;


import com.example.restapi.pojos.ChallengeRequest;
import com.example.restapi.services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Challenge {

    @Autowired
    ChallengeService challengeService;


    @PostMapping("challenge/create")
    public ResponseEntity<String> Createchallenge(HttpServletRequest request, @RequestBody ChallengeRequest challengeRequest){
        challengeService.CreateChallenge(challengeRequest);
        return new ResponseEntity<>("Created Succesfully", HttpStatus.OK);
    }

}
