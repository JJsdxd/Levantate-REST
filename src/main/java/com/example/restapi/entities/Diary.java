package com.example.restapi.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="diary")
public class Diary {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="diary_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name ="diary_title")
    private String diary_title;

    @Column(name ="diary_desc")
    private String diary_desc;

    @Column(name ="diary_date")
    @Temporal(TemporalType.DATE)
    private Date diary_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDiary_title() {
        return diary_title;
    }

    public void setDiary_title(String diary_title) {
        this.diary_title = diary_title;
    }

    public String getDiary_desc() {
        return diary_desc;
    }

    public void setDiary_desc(String diary_desc) {
        this.diary_desc = diary_desc;
    }

    public Date getDiary_date() {
        return diary_date;
    }

    public void setDiary_date(Date diary_date) {
        this.diary_date = diary_date;
    }
}
