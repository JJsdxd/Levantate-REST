package com.example.restapi.pojos;

public class UserChallenges {
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

    public Boolean getChallenge_status() {
        return challenge_status;
    }

    public void setChallenge_status(Boolean challenge_status) {
        this.challenge_status = challenge_status;
    }

    private String challenge_title;
    private String challenge_desc;
    private Boolean challenge_status;

    public Integer getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(Integer challenge_id) {
        this.challenge_id = challenge_id;
    }

    private Integer challenge_id;

}
