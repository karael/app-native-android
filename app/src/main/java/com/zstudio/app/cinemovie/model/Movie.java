package com.zstudio.app.cinemovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Movie implements Parcelable {

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

    protected Movie(Parcel in) {
        id = in.readString();
        idThemoviedb = in.readString();
        slug = in.readString();
        title = in.readString();
        budget = in.readString();
        revenue = in.readString();
        releaseDate = in.readString();
        index1 = in.readString();
        index2 = in.readString();
        index3 = in.readString();
        illu = in.readString();
        cover = in.readString();
        thumbnail = in.readString();
        if (in.readByte() == 0x01) {
            actors = new ArrayList<Actor>();
            in.readList(actors, Actor.class.getClassLoader());
        } else {
            actors = null;
        }
        if (in.readByte() == 0x01) {
            genres = new ArrayList<Genre>();
            in.readList(genres, Genre.class.getClassLoader());
        } else {
            genres = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(idThemoviedb);
        dest.writeString(slug);
        dest.writeString(title);
        dest.writeString(budget);
        dest.writeString(revenue);
        dest.writeString(releaseDate);
        dest.writeString(index1);
        dest.writeString(index2);
        dest.writeString(index3);
        dest.writeString(illu);
        dest.writeString(cover);
        dest.writeString(thumbnail);
        if (actors == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(actors);
        }
        if (genres == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genres);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}