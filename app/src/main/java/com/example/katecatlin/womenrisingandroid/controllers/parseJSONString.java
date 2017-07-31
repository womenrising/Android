package com.example.katecatlin.womenrisingandroid.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by katecatlin on 7/30/17.
 */

public class parseJSONString {

    private String[] parseJSONString(String jsonString) throws JSONException {
        String firstName;
        String lastName;
        Boolean isParticipating;
        String[];
        String description;
        final String RESULTS = "results";
        final String first_name = "first_name";

        //Create a JSONOBject from the JSON string
        JSONObject postingJSONObject = new JSONObject(jsonString);


//        //Get the title and description of the most recent posting
//        title = mostRecentPosting.getString(first_name);
//        description = mostRecentPosting.getString(DESCRIPTION);
//
//        //Make an array out of the two strings you found, the name and the description.
//        String[] arrayOfTitleAndDescription = new String[2];
//        arrayOfTitleAndDescription[0] = title;
//        arrayOfTitleAndDescription[1] = description;

        return arrayOfTitleAndDescription;
    }

}
