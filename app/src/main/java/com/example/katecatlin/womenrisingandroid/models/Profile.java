package com.example.katecatlin.womenrisingandroid.models;

import java.io.Serializable;

/**
 * Created by katecatlin on 7/30/17.
 */

public class Profile implements Serializable {
    private String id;
    private String first_name;
    private String last_name;
    private Boolean is_participating_this_month;
    public Profile[] matches;
    public String pictureURL;
    private String emailAddress;
    //ToDo: Figure out how matched profiles are sent and change model accordingly.

    public Profile () {
    }

    public Profile(String id, String first_name, String last_name, Boolean is_participating_this_month, Profile[] matches, String pictureURL, String emailAddress) {
        this.id = id;
        this.first_name = first_name;
        this.is_participating_this_month = is_participating_this_month;
        this.last_name = last_name;
        this.matches = matches;
        this.pictureURL = pictureURL;
        this.emailAddress = emailAddress;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Boolean getParticipating() {
        return is_participating_this_month;
    }

    public void setParticipating(Boolean participating) {
        is_participating_this_month = participating;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile[] getMatches() {
        return matches;
    }

    public void setMatches(Profile[] matches) {
        this.matches = matches;
    }

    public String getPictureURL() {return pictureURL;}

    public String getEmailAddress() {return emailAddress;}
}
