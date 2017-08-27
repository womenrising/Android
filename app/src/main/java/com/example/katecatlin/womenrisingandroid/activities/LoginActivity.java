package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.katecatlin.womenrisingandroid.R;
import com.example.katecatlin.womenrisingandroid.models.Profile;
import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity {

    public static final String FULL_URL_KEY = "FULL_URL_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeControls();
    }

    private void initializeControls() {
        ImageButton loginButton = (ImageButton) findViewById(R.id.LILoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

    }

    private void handleLogin() {
        // Store a reference to the current activity
        final Activity thisActivity = this;

        LISessionManager.getInstance(getApplicationContext()).init(thisActivity, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                fetchPersonalInfo();
            }

            @Override
            public void onAuthError(LIAuthError error) {
                Log.e("TAG", error.toString());
            }
        }, true);
    }

    // Build the list of member permissions our LinkedIn session requires
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE, Scope.R_EMAILADDRESS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
    }

    private void fetchPersonalInfo () {
        String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,picture-url)?format=json";

        final APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.getRequest(this, url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                try {
                    JSONObject jsonObject = apiResponse.getResponseDataAsJson();
                    Log.d("tag", jsonObject.toString(4));

                    String firstName = jsonObject.getString("firstName");
                    String lastName = jsonObject.getString("lastName");
                    String userID = jsonObject.getString("id");
                    String pictureURL = jsonObject.getString("pictureUrl");
                    Log.d("tag", firstName + " " + lastName + " " + userID + " " + pictureURL);

                    Profile myProfile = new Profile(userID, firstName, lastName, null, null, pictureURL);

                    launchProfileViewActivity(myProfile);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onApiError(LIApiError liApiError) {
                Log.e("TAG", "Error onAPI Login");
            }
        });
    }

    private void launchProfileViewActivity (Profile logedInProfile) {
        Intent intent = new Intent(this, ProfileViewActivity.class);
        intent.putExtra(FULL_URL_KEY, logedInProfile);
        startActivity(intent);
    }

}

