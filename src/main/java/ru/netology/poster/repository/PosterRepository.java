package ru.netology.poster.repository;

import ru.netology.poster.domain.MovieData;

public class PosterRepository {
    private MovieData[] movies = new MovieData[0];

    public MovieData[] findAll() {
        return movies;
    }

    public void save(MovieData movie) {
        MovieData[] tmp = new MovieData[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieData findById(int id) {
        for (MovieData movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        for (MovieData movie : movies) {
            if (movie.getId() == id) {
                MovieData[] tmp = new MovieData[movies.length - 1];
                int copyToIndex = 0;

                for (MovieData oneMovie : movies) {
                    if (oneMovie.getId() != id) {
                        tmp[copyToIndex] = oneMovie;
                        copyToIndex++;
                    }
                }

                movies = tmp;
            }
        }
    }

    public void removeAll() {
        movies = null;
    }
}
