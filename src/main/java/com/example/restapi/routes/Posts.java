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
    public post CreateStory(HttpServletRequest request, @RequestBody StoryRequest storyRequest) {
        int token_user_id = (Integer) request.getAttribute("userId");
        storyRequest.user_id = token_user_id;

        return   postService.CreatePost(storyRequest);
    }


}
