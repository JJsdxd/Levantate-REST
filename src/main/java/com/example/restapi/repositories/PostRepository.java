package com.example.restapi.repositories;


import com.example.restapi.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findById(int story_id);
     void deleteById(int story_id);
     List<Post> findAllByOrderByStorydateDesc();

}
