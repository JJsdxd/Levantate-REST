package com.example.restapi.repositories;


import com.example.restapi.entities.statust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<statust,Integer> {

}
