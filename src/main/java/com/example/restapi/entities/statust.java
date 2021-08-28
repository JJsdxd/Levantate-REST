package com.example.restapi.entities;


import javax.persistence.*;

@Entity
@Table(name = "statust")
public class statust {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int status_id;


    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "challenge_id")
    private Challenges challenges;

    @Column(name = "status")
    private boolean user_status;

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Challenges getChallenges() {
        return challenges;
    }

    public void setChallenges(Challenges challenges) {
        this.challenges = challenges;
    }

    public boolean isUser_status() {
        return user_status;
    }

    public void setUser_status(boolean status) {
        this.user_status = user_status;
    }
}
