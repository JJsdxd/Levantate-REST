package com.example.restapi.routes;


import com.example.restapi.entities.post;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Posts {

    @Autowired
    PostService postService;

    @PostMapping("/post/create")
    public String CreateStory(HttpServletRequest request, @RequestBody StoryRequest storyRequest) {
        int user_id = (Integer) request.getAttribute("userId");
        post post1= postService.CreatePost(storyRequest);
        return "Authorized"+ user_id;
    }


}
