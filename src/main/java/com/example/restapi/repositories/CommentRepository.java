package com.example.restapi.repositories;


import com.example.restapi.entities.Comments;
import com.example.restapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Integer> {

  List<Comments> getAllByPost(Post post);
}
