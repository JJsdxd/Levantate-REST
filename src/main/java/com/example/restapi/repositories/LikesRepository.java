package com.example.restapi.repositories;

import com.example.restapi.entities.Likes;
import com.example.restapi.entities.Post;
import com.example.restapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikesRepository extends JpaRepository<Likes,Integer> {


  Boolean existsByPostAndUser(Post post,User user);
  void deleteByPostAndUser(Post post, User user);
  long count();


}
