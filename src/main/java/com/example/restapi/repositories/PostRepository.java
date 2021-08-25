package com.example.restapi.repositories;


import com.example.restapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findById(long story_id);
     void deleteById(long story_id);

}
