package com.example.restapi.repositories;


import com.example.restapi.entities.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<post,Integer> {



}
