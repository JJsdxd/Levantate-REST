package com.example.restapi.services;

import com.example.restapi.entities.Comments;
import com.example.restapi.entities.User;
import com.example.restapi.entities.Post;
import com.example.restapi.exceptions.CustomAuthException;
import com.example.restapi.pojos.CommentShort;
import com.example.restapi.pojos.DetailedPost;
import com.example.restapi.pojos.SimplePost;
import com.example.restapi.pojos.StoryRequest;
import com.example.restapi.repositories.CommentRepository;
import com.example.restapi.repositories.LikesRepository;
import com.example.restapi.repositories.PostRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    LikesRepository likesRepository;



    @Transactional
    public Post CreatePost(@RequestBody StoryRequest storyRequest) {
        User user = userRepository.findById(storyRequest.user_id);
        Post newpost = new Post();
        newpost.setStory_title(storyRequest.story_title);
        newpost.setStory_desc(storyRequest.story_desc);
        java.util.Date date=new java.util.Date();
        newpost.setStorydate(date);
        newpost.setUser(user);

        return postRepository.save(newpost);
    }

    @Transactional
    public void DeletePost(@RequestParam int story_id, int user_id) {
        Post c_post = postRepository.findById(story_id);
        int userid = c_post.getUser().getId();

        if (userid == user_id) {
            postRepository.deleteById(story_id);
        } else {
            throw new CustomAuthException("You cannot delete this");
        }
    }

    @Transactional
    public DetailedPost getPost(int storyid){

        Post post1 =  postRepository.findById(storyid);
        List<Comments> comments = commentRepository.getAllByPost(post1);
        DetailedPost dpost = new DetailedPost();
        dpost.setLike_count(likesRepository.count());
        dpost.setPost_date(post1.getStorydate());
        dpost.setPost_desc(post1.getStory_desc());
        dpost.setPost_title(post1.getStory_title());
        dpost.setPost_user(post1.getUser().getUsername());
        List<CommentShort> commentl = new ArrayList<>();
        for(Comments cm: comments){
            CommentShort cmn = new CommentShort();
            cmn.setUsername(userRepository.findById(cm.getUser_id()).getUsername());
            cmn.setComment_date(cm.getComment_date());
            cmn.setComment_text(cm.getComment_text());
            commentl.add(cmn);

        }
        dpost.setComments(commentl);
        return dpost;

    }

    public List<SimplePost> PostList(){
        List<Post> post_list = postRepository.findAllByOrderByStorydateDesc();
        List<SimplePost> new_list = new ArrayList<>();
        for(Post p:post_list){
            SimplePost simplePost = new SimplePost();
            simplePost.setPost_id(p.getId());
            simplePost.setPost_title(p.getStory_title());
            simplePost.setPost_desc(p.getStory_desc());
            simplePost.setPost_user(p.getUser().getUsername());
            simplePost.setPost_date(p.getStorydate());
            new_list.add(simplePost);

        }
        return new_list;
    }

}
