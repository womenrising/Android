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

//public class JSONCallLogic extends AsyncTask<Object, Object, Profile> {
//    private static final String API_KEY = "75dmyef990nidj";
//    private static final String SECRET_KEY = "Zic7oE5eyclCUHX8";
//    //This is any string we want to use. This will be used for avoiding CSRF attacks.
//    private static final String STATE = "ywWcCpjJGMhUtD4XvJqEdBzR";
//    //This is the url that LinkedIn Auth process will redirect to. We can put whatever we want that starts with http:// or https:// .
////We use a made up url that we will intercept when redirecting. Avoid Uppercases.
//    //TODO don't know if this is correct
//    private static final String REDIRECT_URI = "https://womenrising.herokuapp.com/users/auth/linkedin/callback";
//    private static final String JSON_GET_REQUEST_URL = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code";
//
//    ProfileInterface profileInterface;
//    private final String LOG_TAG = "JSONCallLogic";
//    String jsonString = "If this is your string, there was an error!";
//
//    public JSONCallLogic(ProfileInterface profileInterface) {
//        this.profileInterface = profileInterface;
//    }
//
//    @Override
//    protected Profile doInBackground(Object... params) {
//
//        final String URL_BASE = "https://www.womenrising.co";
//        final String API_KEY = "";
//
//        HttpURLConnection urlConnection = null;
//        InputStream inputStream = null;
//
//        try {
//            String urlString = URL_BASE + API_KEY;
//            URL urlToUse = new URL(urlString);
//
//            urlConnection = (HttpURLConnection) urlToUse.openConnection();
//            urlConnection.setRequestMethod("GET");
//            urlConnection.connect();
//
//            inputStream = urlConnection.getInputStream();
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//
//            int bytesRead;
//            StringBuilder stringBuilder = new StringBuilder();
//
//            while ((bytesRead = bufferedInputStream.read()) != -1) {
//                stringBuilder.append((char) bytesRead);
//            }
//
//            jsonString = stringBuilder.toString();
//
//
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "IOException ", e);
//            return null;
//        } finally {
//            if (urlConnection != null) {
//                urlConnection.disconnect();
//            }
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//                Log.d(LOG_TAG, "IOException", e);
//            }
//        }
//
////        try {
////            Profile returnedProfile = new Profile();
////            returnedProfile = JSONParseLogic.parseJSONString(jsonString);
////            return returnedProfile;
////        } catch (JSONException e) {
////            return null;
////        }
//    }
//
//    protected void onPostExecute(Profile returnedProfile) {
//        if (returnedProfile != null) {
//            profileInterface.updateProfileViews(returnedProfile);
//            //ToDo: Send profile back through an interface to populate text fields in the activity.
//        }
//    }
//
//    private String createURLForJSONGET () {
//        String uRLForJSONGet = new String(
//                JSON_GET_REQUEST_URL +
//                "&client_id=" + API_KEY +
//                        "&redirect_uri=" + REDIRECT_URI +
//                        "&state=" + STATE
//        );
//
//        return uRLForJSONGet;
//    }
//}
