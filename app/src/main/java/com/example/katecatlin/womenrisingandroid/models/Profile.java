package com.example.katecatlin.womenrisingandroid.models;

import static android.R.attr.id;

/**
 * Created by katecatlin on 7/30/17.
 */

public class Profile {
    private String userID;
    private String firstName;
    private String lastName;
    private Boolean isParticipating;
    private String[] matches;

    public Profile () {
    }

    public Profile(String userID, String firstName, String lastName, Boolean isParticipating, String[] matches) {
        this.userID = userID;
        this.firstName = firstName;
        this.isParticipating = isParticipating;
        this.lastName = lastName;
        this.matches = matches;
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

    public String[] getMatches() {
        return matches;
    }

    public void setMatches(String[] matches) {
        this.matches = matches;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
