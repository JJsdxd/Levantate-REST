package com.example.restapi.services;

import com.example.restapi.entities.Diary;
import com.example.restapi.entities.Post;
import com.example.restapi.entities.User;
import com.example.restapi.pojos.DiaryRequest;
import com.example.restapi.pojos.DiaryResponse;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.repositories.DiaryRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class DiaryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DiaryRepository diaryRepository;

    @Transactional
    public Diary CreateDiary( DiaryRequest diaryRequest, int user_id) {
        User user = userRepository.findById(user_id);
        Diary diary = new Diary();
        diary.setDiary_title(diaryRequest.getTitle());
        diary.setDiary_desc(diaryRequest.getDesc());
        java.util.Date date=new java.util.Date();
        diary.setDiary_date(date);
        diary.setUser(userRepository.findById(user_id));



        return diaryRepository.save(diary);
    }

    @Transactional
    public List<DiaryResponse> GetAllDiary(int user_id){
        List<Diary> diary_list = diaryRepository.findAllByUser(userRepository.findById(user_id));
        List<DiaryResponse> new_list = new ArrayList<>();
        for(Diary u: diary_list){
            DiaryResponse diary = new DiaryResponse();
            diary.setTitle(u.getDiary_title());
            diary.setDesc(u.getDiary_desc());
            diary.setDate(u.getDiary_date());
            new_list.add(diary);

        }
        return new_list;
    }
}
