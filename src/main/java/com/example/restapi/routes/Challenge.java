package com.example.restapi.routes;


import com.example.restapi.entities.statust;
import com.example.restapi.pojos.ChallengeRequest;
import com.example.restapi.pojos.DetailedPost;
import com.example.restapi.pojos.UserChallenges;
import com.example.restapi.services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Challenge {

    @Autowired
    ChallengeService challengeService;


    @CrossOrigin()
    @GetMapping("/challenge")
    public Map<String, Object> GetAllChallenges(HttpServletRequest request) {
        int token_user_id = (Integer) request.getAttribute("userId");
        List<UserChallenges> challenge_list = challengeService.GetChallenges(token_user_id);
        Map<String, Object> map = new HashMap<>();
        map.put("UserChallenges", challenge_list);

        return map;
    }


    @PostMapping("challenge/create")
    public ResponseEntity<String> Createchallenge(HttpServletRequest request, @RequestBody ChallengeRequest challengeRequest) {
        challengeService.CreateChallenge(challengeRequest);
        return new ResponseEntity<>("Created Succesfully", HttpStatus.OK);
    }


}
