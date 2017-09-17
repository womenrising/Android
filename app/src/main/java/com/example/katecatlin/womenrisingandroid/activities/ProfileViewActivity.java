package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katecatlin.womenrisingandroid.R;

import com.example.katecatlin.womenrisingandroid.models.Profile;
import com.squareup.picasso.Picasso;


/**
 * Created by katecatlin on 7/23/17.
 */

public class ProfileViewActivity extends Activity {
    public static final String FULL_URL_KEY = "FULL_URL_KEY";
    Button participateButton;
    ImageView profileImage;
    Profile myProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);
        updateProfileViewFromLinkedin();

        participateButton = (Button) findViewById(R.id.isParticipatingButton);
        participateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //TODO: Figure out how to send this through API
            }

        });
    }

    public void updateProfileViewFromLinkedin () {
        Intent intent = getIntent();
        myProfile = (Profile)intent.getSerializableExtra(FULL_URL_KEY);

        profileImage = (ImageView) findViewById(R.id.profileImage);
        Picasso.with(getApplicationContext()).load(myProfile.getPictureURL()).into(profileImage);

        TextView nameView = (TextView) findViewById(R.id.profileName);
        nameView.setText(myProfile.getFirst_name() + " " + myProfile.getLast_name());

    }

//    @Override
//    public void updateProfileViews(Profile returnedProfile) {
//        String month = "next month";
//        myProfile = returnedProfile;
//
//
//
//        if (myProfile.getParticipating()) {
//            participateButton.setText(R.string.click_to_opt_out);
//        } else {
//            participateButton.setText(R.string.click_to_opt_in);
//        }
//    }

}

