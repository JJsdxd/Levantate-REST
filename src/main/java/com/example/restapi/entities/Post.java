package com.example.restapi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="stories")
public class Post {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory_title() {
        return story_title;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public String getStory_desc() {
        return story_desc;
    }

    public void setStory_desc(String story_desc) {
        this.story_desc = story_desc;
    }

    public Date getStorydate() {
        return storydate;
    }

    public void setStorydate(Date storydate) {
        this.storydate = storydate;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="story_id")
    private long id;

    @Column(name ="story_title")
    private String story_title;

    @Column(name ="story_desc")
    private String story_desc;

    @Column(name ="story_date")
    @Temporal(TemporalType.DATE)
    private Date storydate;


}
