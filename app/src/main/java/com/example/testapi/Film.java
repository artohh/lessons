package com.example.testapi;

public class Film {
    private String filmName;
    private String filmDesc;
    private String filmCoverURL;

    public Film(String filmName, String filmDesc, String filmCoverURL){
        this.filmName = filmName;
        this.filmDesc = filmDesc;
        this.filmCoverURL = filmCoverURL;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmDesc() {
        return filmDesc;
    }

    public void setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
    }

    public String getFilmCoverURL() {
        return filmCoverURL;
    }

    public void setFilmCoverURL(String filmCoverURL) {
        this.filmCoverURL = filmCoverURL;
    }
}
