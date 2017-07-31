package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.katecatlin.womenrisingandroid.R;
import com.example.katecatlin.womenrisingandroid.controllers.JSONCallLogic;

/**
 * Created by katecatlin on 7/23/17.
 */

public class ProfileViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);

        Button participateButton = (Button) findViewById(R.id.isParticipatingButton);
        participateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONCallLogic jsonCaller = new JSONCallLogic();
                jsonCaller.execute();

            }
        });

    }


}

