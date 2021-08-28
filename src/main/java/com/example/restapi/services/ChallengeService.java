package com.example.restapi.services;


import com.example.restapi.entities.Challenges;
import com.example.restapi.entities.statust;
import com.example.restapi.pojos.ChallengeRequest;
import com.example.restapi.repositories.ChallengeRepository;
import com.example.restapi.repositories.StatusRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;



    public Challenges CreateChallenge(ChallengeRequest challengeRequest){
        Challenges chl = new Challenges();
        chl.setChallenge_title(challengeRequest.getChl_title());
        chl.setChallenge_desc(challengeRequest.getChl_desc());
         return challengeRepository.save(chl);
    }



    @Transactional
    public void challenge_init(int user_id){
        List<Challenges> challenge_list = challengeRepository.findAll();

        for(Challenges u: challenge_list){
            System.out.print(u);
            statust status = new statust();
            status.setChallenges(u);
            System.out.println(userRepository.findById(user_id).getUsername());
            status.setUser(userRepository.findById(user_id));
            status.setUser_status(false);
            statusRepository.save(status);

        }
    }


}
