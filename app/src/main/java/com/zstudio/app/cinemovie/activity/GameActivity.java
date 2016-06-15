package com.zstudio.app.cinemovie.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zstudio.app.cinemovie.R;
import com.zstudio.app.cinemovie.fragment.MyAlertDialogFragment;
import com.zstudio.app.cinemovie.fragment.MyDialogFragment;

public class GameActivity extends AppCompatActivity implements View.OnClickListener, MyDialogFragment.UserNameListener {

    private Toolbar toolbar;
    private TextView title;
    private Button hint1;
    private Button hint2;
    private Button hint3;
    private EditText answer;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        title = (TextView) findViewById(R.id.home_label_about);
        toolbar = (Toolbar) findViewById(R.id.game_toolbar_included);
        hint1 = (Button) findViewById(R.id.game_button_hint1);
        hint2 = (Button) findViewById(R.id.game_button_hint2);
        hint3 = (Button) findViewById(R.id.game_button_hint3);
        answer = (EditText) findViewById(R.id.game_answer);

        toolbar.setNavigationOnClickListener(this);
        hint1.setOnClickListener(this);
        hint2.setOnClickListener(this);
        initToolBar();
        //initEvents();
    }

    private void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);
    }

    private void initEvents() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

    }

    private void setScore(int score){
        title.setText(String.format(getString(R.string.game_score), score));
    }

    @Override
    public void onFinishUserDialog(String user) {
        Toast.makeText(this, "Hello, " + user, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        // close existing dialog fragments
        FragmentManager manager = getFragmentManager();
        Fragment frag = manager.findFragmentByTag("fragment_edit_name");
        if (frag != null) {
            manager.beginTransaction().remove(frag).commit();
        }
        switch (view.getId()) {
            case R.id.game_toolbar_included:
                    finish();
                break;


            case R.id.game_button_hint1:
                MyDialogFragment editNameDialog = new MyDialogFragment();
                editNameDialog.show(manager, "fragment_edit_name");
                break;
            case R.id.game_button_hint2:
                MyAlertDialogFragment alertDialogFragment = new MyAlertDialogFragment();
                alertDialogFragment.show(manager, "fragment_edit_name");
                break;
        }
    }

}