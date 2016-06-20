package com.zstudio.app.cinemovie.fragment;


import android.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;


import com.zstudio.app.cinemovie.R;

public class HintLockedDialogFragment extends DialogFragment {

    private Button cancelButton;
    private ImageView hintImage;

    public HintLockedDialogFragment() {}

    public interface HintLockedListener {
        void onFinishHintLockDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_hint_locked, container);

        hintImage = (ImageView) view.findViewById(R.id.game_dialog_imageview_lockedhint);
        cancelButton = (Button) view.findViewById(R.id.game_dialog_button_lockedhint);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        hintImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                HintLockedListener activity = (HintLockedListener) getActivity();
                activity.onFinishHintLockDialog();
            }
        });
        return view;
    }
}