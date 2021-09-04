package com.example.restapi.repositories;


import com.example.restapi.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository  extends JpaRepository<Diary,Integer> {

}
