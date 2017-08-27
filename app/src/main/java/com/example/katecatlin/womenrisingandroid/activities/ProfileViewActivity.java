package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katecatlin.womenrisingandroid.R;

import com.example.katecatlin.womenrisingandroid.interfaces.ProfileInterface;
import com.example.katecatlin.womenrisingandroid.models.Profile;
import com.squareup.picasso.Picasso;


/**
 * Created by katecatlin on 7/23/17.
 */

public class ProfileViewActivity extends Activity implements ProfileInterface {
    Profile myProfile = new Profile();
    Button participateButton;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);
        updateProfileViewFromLinkedin(myProfile);

        participateButton = (Button) findViewById(R.id.isParticipatingButton);
        participateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //TODO: Figure out how to send this through API
            }

        });
    }

    public void updateProfileViewFromLinkedin (Profile loggedInProfile) {
        Picasso.with(getApplicationContext()).load(loggedInProfile.getPictureURL()).into(profileImage);

        TextView nameView = (TextView) findViewById(R.id.profileName);
        nameView.setText(myProfile.getFirstName() + " " + myProfile.getLastName());

    }

    @Override
    public void updateProfileViews(Profile returnedProfile) {
        String month = "next month";
        myProfile = returnedProfile;



        if (myProfile.getParticipating()) {
            participateButton.setText(R.string.click_to_opt_out);
        } else {
            participateButton.setText(R.string.click_to_opt_in);
        }
    }

}

