package ru.netology.poster.domain;

public class MovieData {
    private int id;
    private String movieName;
    private String genre;

    public MovieData(int id, String movieName, String genre) {
        this.id = id;
        this.movieName = movieName;
        this.genre = genre;
    }

    public MovieData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

