package com.example.restapi.pojos;

import java.util.Date;
import java.util.List;

public class DetailedPost {
    private String Post_title;
    private String Post_desc;
    private String Post_user;
    private Date Post_date;


    private Long like_count;

    private List<CommentShort> comments;


    public Long getLike_count() {
        return like_count;
    }

    public void setLike_count(Long like_count) {
        this.like_count = like_count;
    }
    public String getPost_title() {
        return Post_title;
    }

    public void setPost_title(String post_title) {
        Post_title = post_title;
    }

    public String getPost_desc() {
        return Post_desc;
    }

    public void setPost_desc(String post_desc) {
        Post_desc = post_desc;
    }

    public String getPost_user() {
        return Post_user;
    }

    public void setPost_user(String post_user) {
        Post_user = post_user;
    }

    public Date getPost_date() {
        return Post_date;
    }

    public void setPost_date(Date post_date) {
        Post_date = post_date;
    }

    public List<CommentShort> getComments() {
        return comments;
    }

    public void setComments(List<CommentShort> comments) {
        this.comments = comments;
    }
}
