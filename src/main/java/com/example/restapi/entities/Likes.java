package com.example.restapi.entities;


import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "likes_id")
private int id;




    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "story_id")
    private Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
