package com.example.katecatlin.womenrisingandroid.controllers;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;

/**
 * Created by katecatlin on 7/30/17.
 */

public class GetJSONInfo extends AsyncTask<Void, Void, String[]> {
    private final String LOG_TAG = "GetJSONInfo";
    String jsonString = "If this is your string, there was an error!";

    @Override
    protected String[] doInBackground(Void... params) {

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
                stringBuilder.append((char)bytesRead);
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
            String[] parsedJSONString = parseJSONString.parseJSONString(jsonString);
            //Once you get the two strings you want form the JSON string, return them! Returning from this ASYNC task
            //automatically sends you down to "onPostExecute".
            return parsedJSONString;
        } catch (JSONException e) {
            return null;
        }
    }

    }
}
