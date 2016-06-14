package com.zstudio.app.cinemovie.model;

import java.util.ArrayList;

public class Movie{

    private String id;
    private String idThemoviedb;
    private String slug;
    private String title;
    private String budget;
    private String revenue;
    private String releaseDate;
    private String index1;
    private String index2;
    private String index3;
    private String illu;
    private String cover;
    private String thumbnail;
    private ArrayList<Actor> actors;
    private ArrayList<Genre> genres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdThemoviedb() {
        return idThemoviedb;
    }

    public void setIdThemoviedb(String idThemoviedb) {
        this.idThemoviedb = idThemoviedb;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIndex1() {
        return index1;
    }

    public void setIndex1(String index1) {
        this.index1 = index1;
    }

    public String getIndex2() {
        return index2;
    }

    public void setIndex2(String index2) {
        this.index2 = index2;
    }

    public String getIndex3() {
        return index3;
    }

    public void setIndex3(String index3) {
        this.index3 = index3;
    }

    public String getIllu() {
        return illu;
    }

    public void setIllu(String illu) {
        this.illu = illu;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
