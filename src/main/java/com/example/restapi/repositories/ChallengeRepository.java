package com.example.restapi.repositories;


import com.example.restapi.entities.Challenges;
import com.example.restapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenges,Integer> {

    List<Challenges> findAll();


}
