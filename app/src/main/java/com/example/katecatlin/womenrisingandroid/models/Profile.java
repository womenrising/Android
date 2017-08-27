package com.example.katecatlin.womenrisingandroid.models;

import java.io.Serializable;

import static android.R.attr.id;

/**
 * Created by katecatlin on 7/30/17.
 */

public class Profile implements Serializable {
    private String userID;
    private String firstName;
    private String lastName;
    private Boolean isParticipating;
    public Profile[] matches;
    public String pictureURL;
    private String emailAddress;
    //ToDo: Figure out how matched profiles are sent and change model accordingly.

    public Profile () {
    }

    public Profile(String userID, String firstName, String lastName, Boolean isParticipating, Profile[] matches, String pictureURL, String emailAddress) {
        this.userID = userID;
        this.firstName = firstName;
        this.isParticipating = isParticipating;
        this.lastName = lastName;
        this.matches = matches;
        this.pictureURL = pictureURL;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getParticipating() {
        return isParticipating;
    }

    public void setParticipating(Boolean participating) {
        isParticipating = participating;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
