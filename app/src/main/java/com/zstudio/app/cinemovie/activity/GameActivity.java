package com.zstudio.app.cinemovie.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.zstudio.app.cinemovie.CineApplication;
import com.zstudio.app.cinemovie.R;
import com.zstudio.app.cinemovie.adaptater.MovieAdaptater;
import com.zstudio.app.cinemovie.fragment.HintLockedDialogFragment;
import com.zstudio.app.cinemovie.fragment.HintUnlockedDialogFragment;
import com.zstudio.app.cinemovie.fragment.MovieSuccessDialogFragment;
import com.zstudio.app.cinemovie.model.Movie;
import com.zstudio.app.cinemovie.network.NetworkManager;

import org.json.JSONObject;

public class GameActivity extends AppCompatActivity implements View.OnClickListener,
        HintLockedDialogFragment.HintLockedListener, HintUnlockedDialogFragment.HintUnlockedListener,
        MovieSuccessDialogFragment.MovieSuccessListener {

    private Toolbar toolbar;
    private TextView title;
    private Button skip;
    private Button hint1;
    private Button hint2;
    private Button hint3;
    private EditText eAnswer;
    private Button clickedHint;
    private Movie movie;
    private NetworkImageView illustationView;

    private int score;
    private int[] hintOpened;
    private int nbHintOpened;

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        title = (TextView) findViewById(R.id.game_label_score);
        toolbar = (Toolbar) findViewById(R.id.game_toolbar_included);
        hint1 = (Button) findViewById(R.id.game_button_hint1);
        hint2 = (Button) findViewById(R.id.game_button_hint2);
        hint3 = (Button) findViewById(R.id.game_button_hint3);
        skip = (Button) findViewById(R.id.game_button_skip);
                manager = getFragmentManager();
        eAnswer = (EditText) findViewById(R.id.game_answer);

        score = 1000;
        nbHintOpened = 0;
        title.setText(String.format(getString(R.string.game_score), score));

        illustationView = (NetworkImageView) findViewById(R.id.game_illustration);

        toolbar.setNavigationOnClickListener(this);
        hint1.setOnClickListener(this);
        hint2.setOnClickListener(this);
        hint3.setOnClickListener(this);
        skip.setOnClickListener(this);
        eAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                sendAnswer(eAnswer.getText().toString());
            return true;
            }
        });
        initToolBar();
        refreshViewWithMovie();
        eAnswer.requestFocus();

    }

    private void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setIllustationView(){
        illustationView.setImageUrl(movie.getIllu(), CineApplication.getSingleInstance().getImageLoader());
    }

    private void resetButtons() {
        Drawable hintImage = ResourcesCompat.getDrawable(getResources(), R.drawable.hint_hover, null);
        hint1.setBackground(hintImage);
        hint2.setBackground(hintImage);
        hint3.setBackground(hintImage);
    }

    private void refreshViewWithMovie(){
        NetworkManager.getMovie("get_movie", new NetworkManager.JSONObjectResultListener() {
            @Override
            public void onResult(JSONObject result) {
                movie = new MovieAdaptater(result).getMovie();
                setIllustationView();
                nbHintOpened = 0;
                setScore();
                resetButtons();
            }

            @Override
            public void onFail(String statusCode) {
                Log.e("MYAPP", "api response: " + statusCode);
            }
        });
    }

    private void setScore(){
        switch (nbHintOpened) {
            case 1 : score = 800;
                break;
            case 2 : score = 600;
                break;
            case 3 : score = 400;
                break;
            default: score = 1000;
        }
        title.setText(String.format(getString(R.string.game_score), score));
    }

    @Override
    public void onFinishHintLockDialog() {
        HintUnlockedDialogFragment HintUnlockedDialog = new HintUnlockedDialogFragment();
        HintUnlockedDialog.show(manager, "fragment_show_hint_unlocked");
    }

    @Override
    public void onFinishHintUnlockDialog() {
        Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.hint_open_hover, null);
        clickedHint.setBackground(d);
        nbHintOpened++;
        setScore();
    }

    public void onClickMovieDetail(){
        startActivity(new Intent(CineApplication.getSingleInstance(), MovieDetailsActivity.class));
    }
    public void onClickMovieNext(){
        refreshViewWithMovie();
    }

    public void sendAnswer(String answer) {
        NetworkManager.postMovieAnswer("post_score", movie.getId(), nbHintOpened, answer, new NetworkManager.JSONObjectResultListener() {
            @Override
            public void onResult(JSONObject result) {
                CineApplication.getSingleInstance().setScore(String.valueOf(score));
                MovieSuccessDialogFragment movieSuccessDialogFragment = new MovieSuccessDialogFragment();
                movieSuccessDialogFragment.show(manager, "fragment_show_game_success");
            }

            @Override
            public void onFail(String statusCode) {
                Log.e("MYAPP", "api response: " + statusCode);
            }
        });
    }

    @Override
    public void onClick(View view) {
        HintLockedDialogFragment HintLockDialog = new HintLockedDialogFragment();
        switch (view.getId()) {

            case R.id.game_button_hint1:
                HintLockDialog.show(manager, "fragment_show_hint1_locked");
                clickedHint = hint1;
                CineApplication.getSingleInstance().setHint(movie.getIndex1());
                break;
            case R.id.game_button_hint2:
                HintLockDialog.show(manager, "fragment_show_hint2_locked");
                clickedHint = hint2;
                CineApplication.getSingleInstance().setHint(movie.getIndex2());
                break;
            case R.id.game_button_hint3:
                HintLockDialog.show(manager, "fragment_show_hint3_locked");
                clickedHint = hint3;
                CineApplication.getSingleInstance().setHint(movie.getIndex3());
                break;
            case R.id.game_button_skip:
                Log.d("tag", "skippppp");
                refreshViewWithMovie();
                break;
        }
        setScore();
    }

}