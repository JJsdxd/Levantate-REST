package com.example.restapi.entities;


import javax.persistence.*;

@Entity
@Table(name = "challenges")
public class Challenges {

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }




    public String getChallenge_title() {
        return challenge_title;
    }

    public void setChallenge_title(String challenge_title) {
        this.challenge_title = challenge_title;
    }

    public String getChallenge_desc() {
        return challenge_desc;
    }

    public void setChallenge_desc(String challenge_desc) {
        this.challenge_desc = challenge_desc;
    }





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id")
    private int challenge_id;

    @OneToOne
    @JoinColumn(name = "challenge_id")
    private statust status;

    @Column(name = "challenge_title")
    private String challenge_title;

    @Column(name = "challenge_desc")
    private String challenge_desc;



}
