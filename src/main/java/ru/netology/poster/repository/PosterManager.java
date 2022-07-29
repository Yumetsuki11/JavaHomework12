package ru.netology.poster.repository;

import ru.netology.poster.domain.MovieData;

public class PosterManager {
    private MovieData[] movies = new MovieData[0];
    private int limit = 10;

    public PosterManager() {
    }

    public PosterManager(int limit) {
        if (limit > -1) {
            this.limit = limit;
        }
    }

    public int getLimit() {
        return limit;
    }

    public MovieData findById(int id) {
        for (MovieData movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(MovieData movie) {
        MovieData[] tmp = new MovieData[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieData[] findAll() {
        return movies;
    }

    public MovieData[] findLast() {
        int resultLength = limit;
        if (resultLength > movies.length) {
            resultLength = movies.length;
        }
        MovieData[] result = new MovieData[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }
}
