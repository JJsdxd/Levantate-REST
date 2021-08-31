package com.example.restapi.repositories;


import com.example.restapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findById(int story_id);
     void deleteById(int story_id);

}
