package com.zstudio.app.cinemovie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.zstudio.app.cinemovie.CineApplication;
import com.zstudio.app.cinemovie.R;

public class HomeActivity extends AppCompatActivity {

    private Button playButton;
    private Button achievementButton;
    private TextView aboutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        //setup ids
        playButton = (Button) findViewById(R.id.home_button_play);
        achievementButton = (Button) findViewById(R.id.home_button_achievements);
        aboutTextView = (TextView) findViewById(R.id.home_label_about);

        //events
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity("game");
            }
        });

        achievementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity("achievement");
            }
        });

        aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity("about");
            }
        });

    }

    private void launchActivity(String activitySelected) {
        switch (activitySelected) {
            case "game": startActivity(new Intent(CineApplication.getSingleInstance(), GameActivity.class));
                break;
            case "achievement": startActivity(new Intent(CineApplication.getSingleInstance(), AchievementActivity.class));
                break;
            case "about": startActivity(new Intent(CineApplication.getSingleInstance(), AboutActivity.class));
                break;
            default: startActivity(new Intent(CineApplication.getSingleInstance(), GameActivity.class));
                break;
        }
    }
}