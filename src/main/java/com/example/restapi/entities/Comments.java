package com.example.restapi.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;


    @ManyToOne
    @JoinColumn(name ="story_id")
    private Post post;


    @Column(name = "user_id")
    private int user_id;

    @Column(name = "comment_text")
    private String comment_text;

    @Column(name="comment_date")
    @Temporal(TemporalType.DATE)
    private Date comment_date;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
}
