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


    public interface TestResultListener {
        void onResult(JSONObject result);
        void onFail();
    }

    public static void getTest(String tag,
                               final TestResultListener listener) {
        // Tag used to cancel the request
        final String TAG = tag;
        String url = "http://163.172.29.197:3000/api/movie";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                            if(listener!=null) {
                                listener.onResult(response);
                            }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                listener.onFail();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("X-app-UUID", "132132131232112");
                return headers;
            }

        };
        CineApplication.getSingleInstance().getRequestQueue().add(jsonObjReq);
    }
}
