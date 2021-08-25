package com.example.restapi.services;

import com.example.restapi.entities.User;
import com.example.restapi.entities.Post;
import com.example.restapi.exceptions.CustomAuthException;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.repositories.PostRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;


    @Transactional
    public Post CreatePost(@RequestBody StoryRequest storyRequest) {
        User user = userRepository.findById(storyRequest.user_id);
        Post newpost = new Post();
        newpost.setStory_title(storyRequest.story_title);
        newpost.setStory_desc(storyRequest.story_desc);
        java.util.Date date=new java.util.Date();
        newpost.setStorydate(date);
        newpost.setUser(user);

        return postRepository.save(newpost);
    }

    @Transactional
    public void DeletePost(@RequestParam long story_id, int user_id) {
        Post c_post = postRepository.findById(story_id);
        int userid = c_post.getUser().getId();

        if (userid == user_id) {
            postRepository.deleteById(story_id);
        } else {
            throw new CustomAuthException("You cannot delete this");
        }
    }

    @Transactional
    public Post getPost( int storyid){
        return postRepository.findById(storyid);
    }
}
