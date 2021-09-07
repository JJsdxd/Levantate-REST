package com.example.restapi.routes;


import com.example.restapi.pojos.DiaryRequest;
import com.example.restapi.pojos.DiaryResponse;
import com.example.restapi.pojos.SimplePost;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DiaryRoute {


    @Autowired
    DiaryService diaryService;


    //Creating a new Diary entry
    @CrossOrigin
    @PostMapping("/diary/create")
    public ResponseEntity<String> CreateStory(HttpServletRequest request, @RequestBody DiaryRequest diaryRequest) {
        int token_user_id = (Integer) request.getAttribute("userId");
        diaryService.CreateDiary(diaryRequest, token_user_id);

        return new ResponseEntity<>("Created Sucesfully", HttpStatus.OK);


    }

    //Get all diary entries of the user
    @CrossOrigin
    @GetMapping("/diary")
    public Map<String, Object> GetAllDiary(HttpServletRequest request) {
        int token_user_id = (Integer) request.getAttribute("userId");
        List<DiaryResponse> diary_response = diaryService.GetAllDiary(token_user_id);
        Map<String, Object> map = new HashMap<>();
        map.put("ListOfDiaryEntries", diary_response);

        return map;

    }
}
