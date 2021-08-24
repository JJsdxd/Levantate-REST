package com.example.restapi.routes;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class Posts {

    @Autowired
    PostService postService;

    @PostMapping("/post/create")
    public ResponseEntity<String> CreateStory(HttpServletRequest request, @RequestBody StoryRequest storyRequest) {
        int token_user_id = (Integer) request.getAttribute("userId");
        storyRequest.user_id = token_user_id;
        postService.CreatePost(storyRequest);
        return   new ResponseEntity<>("Created Sucesfully", HttpStatus.OK);
    }

    @PostMapping("post/delete")
    public ResponseEntity<String> DeleteStory(HttpServletRequest request, @RequestParam int story_id){
        System.out.println(story_id);
        int token_user_id = (Integer) request.getAttribute("userId");
        postService.DeletePost(story_id,token_user_id);
        return new ResponseEntity<>("Story with id"+story_id+"deleted succesfully", HttpStatus.OK);
    }


}
