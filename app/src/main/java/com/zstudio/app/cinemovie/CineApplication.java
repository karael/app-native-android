package com.zstudio.app.cinemovie;

import android.app.Application;
import android.provider.Settings.Secure;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class CineApplication extends Application {

    private String androidId;
    private String userId;
    private static CineApplication singleInstance;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        androidId = Secure.getString(getApplicationContext().getContentResolver(),
                Secure.ANDROID_ID);
        requestQueue = Volley.newRequestQueue(this);
        CineApplication.singleInstance = this;
    }

    public void setUserId(String id) {
        userId = id;
    }

    public String getUserId() {
        return userId;
    }

    public static CineApplication getSingleInstance() {
        return singleInstance;
    }

    public String getAndroidId() {
        return androidId;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}