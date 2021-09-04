package com.example.restapi.services;

import com.example.restapi.entities.Diary;
import com.example.restapi.entities.Post;
import com.example.restapi.entities.User;
import com.example.restapi.pojos.DiaryRequest;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.repositories.DiaryRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class DiaryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DiaryRepository diaryRepository;

    @Transactional
    public Diary CreateDiary(@RequestBody DiaryRequest diaryRequest, int user_id) {
        User user = userRepository.findById(user_id);
        Diary diary = new Diary();
        diary.setDiary_title(diaryRequest.getTitle());
        diary.setDiary_desc(diaryRequest.getDesc());
        java.util.Date date=new java.util.Date();
        diary.setDiary_date(date);
        diary.setUser(userRepository.findById(user_id));



        return diaryRepository.save(diary);
    }
}
