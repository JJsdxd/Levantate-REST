package com.example.restapi.pojos;

public class ChallengeRequest {

    public String getChl_title() {
        return chl_title;
    }

    public void setChl_text(String chl_title) {
        this.chl_title = chl_title;
    }

    public String getChl_desc() {
        return chl_desc;
    }

    public void setChl_desc(String chl_desc) {
        this.chl_desc = chl_desc;
    }

    private String chl_title;
    private String chl_desc;

}
