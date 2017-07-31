package com.example.katecatlin.womenrisingandroid.controllers;

import com.example.katecatlin.womenrisingandroid.models.Profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by katecatlin on 7/30/17.
 */

public class JSONParseLogic {

    public static Profile parseJSONString(String jsonString) throws JSONException {
        final Profile[] peers = null;

        JSONObject wrJSONObject = new JSONObject(jsonString);

        //ToDo: figure out how matched profiles are sent and fix JSON parsing accordingly.

        Profile newProfile = new Profile (
                Integer.parseInt(wrJSONObject.getString("id")),
                wrJSONObject.getString("first_name"),
                wrJSONObject.getString("last_name"),
                Boolean.parseBoolean(wrJSONObject.getString("is_participating_this_month")),
                null);

        return newProfile;
    }

}
