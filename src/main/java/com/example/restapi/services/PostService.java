package com.example.restapi.services;

import com.example.restapi.entities.User;
import com.example.restapi.entities.post;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.repositories.PostRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public post CreatePost(@RequestBody StoryRequest storyRequest){
        User user = userRepository.findById(storyRequest.user_id);
        post newpost = new post();
        newpost.setStory_title(storyRequest.story_title);
        newpost.setStory_desc(storyRequest.story_desc);
        newpost.setStorydate(new Date(119, 6, 18));
        newpost.setUser(user);

        return postRepository.save(newpost);
    }
}
