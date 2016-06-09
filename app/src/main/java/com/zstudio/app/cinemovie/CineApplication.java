package com.zstudio.app.cinemovie;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import com.zstudio.app.cinemovie.network.LruBitmapCache;

public class CineApplication extends Application {

    private String uuid;
    private RequestQueue requestQueue;
    private static CineApplication singleInstance;
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        //instance du singleton
        CineApplication.singleInstance = this;
        requestQueue = Volley.newRequestQueue(this);
        LruBitmapCache lruBitmapCache = new LruBitmapCache(8 * 1024 * 1024); //8Mo
        imageLoader = new ImageLoader(requestQueue, lruBitmapCache);


    }

    public static CineApplication getSingleInstance() {

        return singleInstance;
    }

    public RequestQueue getRequestQueue() {

        return requestQueue;
    }

    public ImageLoader getImageLoader() {

        return imageLoader;
    }

    public void setUuid(String userUuid) {
        uuid = userUuid;
    }

    public String getUuid() {
        return uuid;
    }

}


