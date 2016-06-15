package com.zstudio.app.cinemovie.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.zstudio.app.cinemovie.CineApplication;
import com.zstudio.app.cinemovie.R;
import com.zstudio.app.cinemovie.model.Movie;
import com.zstudio.app.cinemovie.network.NetworkManager;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private Activity activity = this;
    private TextView tv;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv = (TextView) findViewById(R.id.textTester);
        bt = (Button) findViewById(R.id.btTester);
        List<Movie> movies = new ArrayList<>();
        setTitle("test");
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        //pDialog.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("coucou")
                .setTitle("title");
        final AlertDialog dialog = builder.create();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshText(CineApplication.getSingleInstance().getAndroidId());
            }
        });

        NetworkManager.getUserId("Test", new NetworkManager.JSONObjectResultListener() {
            @Override
            public void onResult(JSONObject result) {
                pDialog.setMessage("Done");
                pDialog.hide();
                refreshText(result.toString());
            }

            @Override
            public void onFail(Integer statusCode) {
                    pDialog.setMessage("Error: " + statusCode);
            }
        });
    }

    private void refreshText(String str) {
        tv.append(CineApplication.getSingleInstance().getUserId());
    }

}
