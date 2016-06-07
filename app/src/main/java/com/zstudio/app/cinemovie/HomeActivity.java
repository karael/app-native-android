package com.zstudio.app.cinemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void onClickPlayButton(View view) {
        Intent myTriggerActivityIntent = new Intent(this, GameActivity.class);
        startActivity(myTriggerActivityIntent);
    }

    public void onClickAchievementButton(View view) {
        Intent myTriggerActivityIntent = new Intent(this, GameActivity.class);
        startActivity(myTriggerActivityIntent);
    }

}