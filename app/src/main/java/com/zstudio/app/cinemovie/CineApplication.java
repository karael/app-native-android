package com.zstudio.app.cinemovie;

import android.app.Application;
import android.provider.Settings.Secure;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import com.zstudio.app.cinemovie.network.LruBitmapCache;


public class CineApplication extends Application {

    private String androidId;
    private String userId;
    private String hint;
    private String score;

    private static CineApplication singleInstance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        androidId = Secure.getString(getApplicationContext().getContentResolver(),
                Secure.ANDROID_ID);
        requestQueue = Volley.newRequestQueue(this);
        CineApplication.singleInstance = this;
        LruBitmapCache lruBitmapCache = new LruBitmapCache(8 * 1024 * 1024); //8Mo
        imageLoader = new ImageLoader(requestQueue, lruBitmapCache);
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
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}