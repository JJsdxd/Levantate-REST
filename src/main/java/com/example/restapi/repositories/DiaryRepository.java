package com.example.restapi.repositories;


import com.example.restapi.entities.Diary;
import com.example.restapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository  extends JpaRepository<Diary,Integer> {

    List<Diary> findAllByUser(User user);

}
