package com.example.katecatlin.womenrisingandroid.controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.example.katecatlin.womenrisingandroid.interfaces.ProfileInterface;
import com.example.katecatlin.womenrisingandroid.models.Profile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;

/**
 * Created by katecatlin on 7/30/17.
 */

public class JSONCallLogic extends AsyncTask<Object, Object, Profile> {
    ProfileInterface profileInterface;
    private final String LOG_TAG = "JSONCallLogic";
    String jsonString = "If this is your string, there was an error!";

    public JSONCallLogic(ProfileInterface profileInterface) {
        this.profileInterface = profileInterface;
    }

    @Override
    protected Profile doInBackground(Object... params) {

        final String URL_BASE = "https://www.womenrising.co";
        final String API_KEY = "";

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            String urlString = URL_BASE + API_KEY;
            URL urlToUse = new URL(urlString);

            urlConnection = (HttpURLConnection) urlToUse.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            int bytesRead;
            StringBuilder stringBuilder = new StringBuilder();

            while ((bytesRead = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char) bytesRead);
            }

            jsonString = stringBuilder.toString();


        } catch (IOException e) {
            Log.e(LOG_TAG, "IOException ", e);
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                Log.d(LOG_TAG, "IOException", e);
            }
        }

        try {
            Profile returnedProfile = new Profile();
            returnedProfile = JSONParseLogic.parseJSONString(jsonString);
            return returnedProfile;
        } catch (JSONException e) {
            return null;
        }
    }

    protected void onPostExecute(Profile returnedProfile) {
        if (returnedProfile != null) {
            profileInterface.updateProfileTextViews(returnedProfile);
            //ToDo: Send profile back through an interface to populate text fields in the activity.
        }
    }
}
