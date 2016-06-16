package com.zstudio.app.cinemovie.fragment;


import android.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;


import com.zstudio.app.cinemovie.CineApplication;
import com.zstudio.app.cinemovie.R;

public class HintUnlockedDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button cancelButton;
    private TextView hint;

    public HintUnlockedDialogFragment() {}

    public interface HintUnlockedListener {
        void onFinishHintUnlockDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_hint_unlocked, container);

        hint = (TextView) view.findViewById(R.id.game_dialog_hint_text);
        hint.setOnClickListener(this);

        cancelButton = (Button) view.findViewById(R.id.game_dialog_button_unlockedhint);
        cancelButton.setOnClickListener(this);
        setHintValue(CineApplication.getSingleInstance().getHint());

        return view;
    }


    @Override
    public void onClick(View view) {
        this.dismiss();
        HintUnlockedListener activity = (HintUnlockedListener) getActivity();
        activity.onFinishHintUnlockDialog();

    }

    private void setHintValue(String hintValue) {
        String[] hintSplit = hintValue.split(";");
        String hintFormated = getString(R.string.game_dialog_hint_value,
                hintSplit[0], hintSplit[1]);
        hint.setText(hintFormated);
    }
}