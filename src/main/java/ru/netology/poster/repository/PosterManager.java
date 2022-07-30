package ru.netology.poster.repository;

import ru.netology.poster.domain.MovieData;

public class PosterManager {
    private int limit = 10;
    private PosterRepository repo;

    public PosterManager(PosterRepository repo) {
        this.repo = repo;
    }

    public PosterManager(PosterRepository repo, int limit) {
        this.repo = repo;
        if (limit > -1) {
            this.limit = limit;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void addMovie(MovieData movie) {
        repo.save(movie);
    }

    public MovieData[] findAll() {
        return repo.findAll();
    }

    public MovieData[] findLast() {
        MovieData[] movies = repo.findAll();
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
