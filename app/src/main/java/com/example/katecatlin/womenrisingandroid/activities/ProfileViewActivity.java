package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.katecatlin.womenrisingandroid.R;
import com.example.katecatlin.womenrisingandroid.controllers.JSONCallLogic;

import com.example.katecatlin.womenrisingandroid.interfaces.ProfileInterface;
import com.example.katecatlin.womenrisingandroid.models.Profile;


/**
 * Created by katecatlin on 7/23/17.
 */

public class ProfileViewActivity extends Activity implements ProfileInterface {
    Profile myProfile = new Profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);

        Button participateButton = (Button) findViewById(R.id.isParticipatingButton);
        participateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //TODO: Figure out how to send this through API
            }

        });
    }

    @Override
    public void updateProfileTextViews(Profile returnedProfile) {
        myProfile = returnedProfile;
        TextView nameView = (TextView) findViewById(R.id.profileName);
        nameView.setText(myProfile.getFirstName() + myProfile.getLastName());

    }


}

