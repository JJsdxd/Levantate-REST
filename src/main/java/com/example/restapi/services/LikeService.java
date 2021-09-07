package com.example.restapi.services;


import com.example.restapi.entities.Likes;
import com.example.restapi.repositories.LikesRepository;
import com.example.restapi.repositories.PostRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class LikeService {


    @Autowired
    LikesRepository likesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    public void EditLike(int userid, int storyid) {
        Boolean test = likesRepository.existsByPostAndUser(postRepository.findById(storyid), userRepository.findById(userid));
        System.out.println(test);

        if (test) {
            likesRepository.deleteByPostAndUser(postRepository.findById(storyid), userRepository.findById(userid));

        } else {
            System.out.println("tetst");
            Likes like2 = new Likes();
            like2.setPost(postRepository.findById(storyid));
            like2.setUser(userRepository.findById(userid));
            System.out.println(like2);
            likesRepository.save(like2);

        }

    }
}
