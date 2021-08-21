package com.example.restapi.services;


import com.example.restapi.entities.User;
import com.example.restapi.exceptions.CustomAuthException;
import com.example.restapi.pojos.ImageUpload;
import com.example.restapi.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

   public UserService(){}

    public void  UpdateProfile(ImageUpload imgupload) throws CustomAuthException{

        User cuser = userRepository.findById(imgupload.userid);
        if(cuser!=null) {
            cuser.setPicByte(imgupload.imagebytes);
            userRepository.save(cuser);
        }
        else throw new CustomAuthException("UserNotFound");


    }

    public byte[] findImage(int id) {
       User cuser = userRepository.findById(id);
       return cuser.getPicByte();

    }


       public List<User> getUsers(){
           return userRepository.findAll();
       }

      public User LoginUser(User user) throws CustomAuthException{
       List<User> userl = userRepository.findByUsername(user.getUsername());
       if(userl.isEmpty()){
           throw new CustomAuthException("User Not Found");
       }
       for(User u:userl){
           if(!BCrypt.checkpw(user.getPassword(),u.getPassword())){
               throw new CustomAuthException("Incorrect Password");
           }

       }

          return userl.get(0);

      }

       public User CreateUser(User user)throws CustomAuthException{

          List<User> test1 = userRepository.findByEmail(user.getEmail());
           List<User> tests = userRepository.findByUsername(user.getUsername());
           if(test1.size()!=0){
               throw new CustomAuthException("Email Already in use");
           }
           if(tests.size()!=0){
               throw new CustomAuthException("Username is taken");

           }
           return  userRepository.save(user);
       }
}
