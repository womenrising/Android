package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.katecatlin.womenrisingandroid.R;
import com.example.katecatlin.womenrisingandroid.controllers.JSONCallLogic;


public class LoginActivity extends Activity {
    
    //https://stackoverflow.com/questions/22062145/oauth-2-0-authorization-for-linkedin-in-android


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton loginButton = (ImageButton) findViewById(R.id.LILoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONCallLogic jsonCallLogic = new JSON
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(JSONCallLogic.createURLForJSONGET()));
                startActivity(intent);
            }
        });
    }
}
