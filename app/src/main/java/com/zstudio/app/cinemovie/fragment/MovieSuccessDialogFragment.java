package com.zstudio.app.cinemovie.fragment;


import android.app.DialogFragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;


import com.zstudio.app.cinemovie.CineApplication;
import com.zstudio.app.cinemovie.R;

public class MovieSuccessDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button next;
    private Button seeMore;
    private TextView score;

    public MovieSuccessDialogFragment() {}

    public interface MovieSuccessListener {
        void onClickMovieDetail();
        void onClickMovieNext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_success, container);


        next = (Button) view.findViewById(R.id.game_dialog_button_nextBt);
        seeMore = (Button) view.findViewById(R.id.game_dialog_button_see_moreBt);
        score = (TextView) view.findViewById(R.id.game_dialog_success_scoreTv);

        seeMore.setOnClickListener(this);
        next.setOnClickListener(this);
        score.setText(String.format(getString(R.string.game_dialog_success_score), CineApplication.getSingleInstance().getScore()));
        setStars();
        return view;
    }


    @Override
    public void onClick(View view) {
        MovieSuccessListener activity = (MovieSuccessListener) getActivity();
        switch (view.getId()) {
            case R.id.game_dialog_button_nextBt:
                activity.onClickMovieNext();
                break;
            case R.id.game_dialog_button_see_moreBt:
                activity.onClickMovieDetail();
                break;
        }
        this.dismiss();
    }

    public void setStars(){
        String scoreValue =  CineApplication.getSingleInstance().getScore();
        switch (scoreValue) {
            case "800": Drawable starts = ResourcesCompat.getDrawable(getResources(), R.drawable.circle2stars, null);
                score.setBackground(starts);
                break;
            case "600": Drawable oneStarts = ResourcesCompat.getDrawable(getResources(), R.drawable.circle1stars, null);
                score.setBackground(oneStarts);
                break;
            case "400": Drawable oneeStarts = ResourcesCompat.getDrawable(getResources(), R.drawable.circle1stars, null);
                score.setBackground(oneeStarts);
                break;
        }

    }
}