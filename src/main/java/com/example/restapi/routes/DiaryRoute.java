package com.example.restapi.routes;


import com.example.restapi.pojos.DiaryRequest;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DiaryRoute {


    @Autowired
    DiaryService diaryService;

    @CrossOrigin
    @PostMapping("/diary/create")
    public ResponseEntity<String> CreateStory(HttpServletRequest request, @RequestBody DiaryRequest diaryRequest) {
        int token_user_id = (Integer) request.getAttribute("userId");
        diaryService.CreateDiary(diaryRequest,token_user_id);

        return new ResponseEntity<>("Created Sucesfully", HttpStatus.OK);


    }
}
