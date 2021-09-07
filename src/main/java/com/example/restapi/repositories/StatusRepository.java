package com.example.restapi.repositories;


import com.example.restapi.entities.User;
import com.example.restapi.entities.statust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<statust, Integer> {
    List<statust> findByUser(User user);

}
