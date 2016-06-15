package com.zstudio.app.cinemovie.network;


import android.app.ProgressDialog;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.zstudio.app.cinemovie.CineApplication;
import com.zstudio.app.cinemovie.model.Movie;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NetworkManager {


    public interface JSONObjectResultListener {
        void onResult(JSONObject result);
        void onFail(Integer statusCode);
    }

    public static void getUserId(String tag,
                               final JSONObjectResultListener listener) {

        final String TAG = tag;
        final String url = "http://163.172.29.197:3000/api/user";
        final String UUID = CineApplication.getSingleInstance().getAndroidId();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(listener!=null) {
                            listener.onResult(response);
                        }
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG + " UUID: " + UUID);
                VolleyLog.d(TAG + " code: " + error.networkResponse.statusCode);
                VolleyLog.d(TAG + " Error: " + error.toString());
                listener.onFail(error.networkResponse.statusCode);
            }

        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("X-app-UUID", UUID);
                return headers;
            }

        };

        CineApplication.getSingleInstance().getRequestQueue().add(jsonObjReq);
    }

    public static void getMovie(String tag,
                                 final JSONObjectResultListener listener) {

        final String TAG = tag;
        final String url = "http://163.172.29.197:3000/api/user";
        final String UUID = CineApplication.getSingleInstance().getAndroidId();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(listener!=null) {
                            listener.onResult(response);
                        }
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG + " UUID: " + UUID);
                VolleyLog.d(TAG + " code: " + error.networkResponse.statusCode);
                VolleyLog.d(TAG + " Error: " + error.toString());
                listener.onFail(error.networkResponse.statusCode);
            }

        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("X-app-UUID", UUID);
                return headers;
            }

        };

        CineApplication.getSingleInstance().getRequestQueue().add(jsonObjReq);
    }

    public static void getAchievement(String tag,
                                 final JSONObjectResultListener listener) {

        final String TAG = tag;
        final String url = "http://163.172.29.197:3000/api/user";
        final String UUID = CineApplication.getSingleInstance().getAndroidId();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(listener!=null) {
                            listener.onResult(response);
                        }
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG + " UUID: " + UUID);
                VolleyLog.d(TAG + " code: " + error.networkResponse.statusCode);
                VolleyLog.d(TAG + " Error: " + error.toString());
                listener.onFail(error.networkResponse.statusCode);
            }

        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("X-app-UUID", UUID);
                return headers;
            }

        };

        CineApplication.getSingleInstance().getRequestQueue().add(jsonObjReq);
    }

}
