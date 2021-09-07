package com.example.restapi.services;


import com.example.restapi.entities.Comments;
import com.example.restapi.entities.Post;
import com.example.restapi.pojos.CommentRequest;
import com.example.restapi.repositories.CommentRepository;
import com.example.restapi.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;


    public Comments createComment(CommentRequest commentRequest, int userid) {
        Comments cmt1 = new Comments();
        cmt1.setUser_id(userid);
        cmt1.setComment_text(commentRequest.comment_text);
        cmt1.setPost(postRepository.findById(commentRequest.story_id));
        java.util.Date date = new java.util.Date();
        cmt1.setComment_date(date);
        return commentRepository.save(cmt1);

    }

    public List<Comments> GetComments(Post post) {
        return commentRepository.getAllByPost(post);

    }


}
