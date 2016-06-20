package com.zstudio.app.cinemovie.adaptater;

import android.util.Log;

import com.zstudio.app.cinemovie.model.Movie;

import org.json.JSONException;
import org.json.JSONObject;


public class MovieAdaptater {

    private JSONObject json;
    private Movie movie;

    public MovieAdaptater(JSONObject response) {
        json = response;
        movie = new Movie();
        refreshMovie();
    }

    public Movie getMovie() {
        return movie;
    }

    private void refreshMovie() {
        try {
            movie.setId(json.getJSONObject("data").getString("_id"));
            movie.setIdThemoviedb(json.getJSONObject("data").getString("id_themoviedb"));
            movie.setSlug(json.getJSONObject("data").getString("slug"));
            movie.setTitle(json.getJSONObject("data").getString("title"));
            movie.setBudget(json.getJSONObject("data").getString("budget"));
            movie.setRevenue(json.getJSONObject("data").getString("revenue"));
            movie.setReleaseDate(json.getJSONObject("data").getString("release_date"));
            movie.setIndex1(json.getJSONObject("data").getString("index_1"));
            movie.setIndex2(json.getJSONObject("data").getString("index_2"));
            movie.setIndex3(json.getJSONObject("data").getString("index_3"));
            movie.setIllu(json.getJSONObject("data").getString("illu"));
            movie.setCover(json.getJSONObject("data").getString("cover"));
            movie.setThumbnail(json.getJSONObject("data").getString("thumbnail"));
            //movie.setActors()
            //movie.setGenres()

        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
    }
}
