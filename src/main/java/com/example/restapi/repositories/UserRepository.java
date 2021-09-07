package com.example.restapi.repositories;

import com.example.restapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    List<User> findByEmailIs(String email);

    List<User> findByUsernameIs(String username);
}
