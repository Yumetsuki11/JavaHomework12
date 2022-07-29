package ru.netology.poster.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.poster.domain.MovieData;

public class PosterManagerTest {
    @Test
    public void noArgsConstructorTest() {
        PosterManager manager = new PosterManager();

        Assertions.assertEquals(10, manager.getLimit());
    }

    @ParameterizedTest
    @CsvSource({
            "-42, 10",
            "-1, 10",
            "0, 0",
            "1, 1",
            "10, 10",
            "1337, 1337"
    })
    public void parameterizedConstructorTest(int limit, int expected) {
        PosterManager manager = new PosterManager(limit);

        Assertions.assertEquals(expected, manager.getLimit());
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "9"
    })
    public void addMovieAndFindAllTest(int startingLength) {
        PosterManager manager = new PosterManager();
        MovieData[] expected = new MovieData[startingLength + 1];

        for (int i = 0; i <= startingLength; i++) {
            MovieData movie = new MovieData(i, "Форсаж " + (i + 1), "криминал");
            manager.addMovie(movie);
            expected[i] = movie;
        }

        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "500, 0",
            "-3, 1",
            "-34, 1",
            "-3, 2",
            "-2, 2",
            "42, 2",
            "-3, 10",
            "-2, 10",
            "0, 10",
            "5, 10",
            "6, 10",
            "28, 10"
    })
    public void findByIdTest(int id, int moviesLength) {
        PosterManager manager = new PosterManager();
        MovieData[] repeaterArray = new MovieData[moviesLength];

        for (int i = 0; i < moviesLength; i++) {
            MovieData movie = new MovieData(i - 3, "Форсаж " + (i + 1), "криминал");
            manager.addMovie(movie);
            repeaterArray[i] = movie;
        }

        MovieData expected;
        if (id + 3 < moviesLength & id + 3 >= 0) {
            expected = repeaterArray[id + 3];
        } else {
            expected = null;
        }

        Assertions.assertEquals(expected, manager.findById(id));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0, 1",
            "0, 10",
            "1, 0",
            "1, 1",
            "1, 10",
            "10, 0",
            "10, 1",
            "10, 5",
            "10, 9",
            "10, 10",
            "10, 11",
            "10, 13"
    })
    public void findLastTest(int limit, int moviesLength) {
        int expectedLength = limit;
        if (expectedLength > moviesLength) {
            expectedLength = moviesLength;
        }

        PosterManager manager = new PosterManager(limit);
        MovieData[] expected = new MovieData[expectedLength];

        for (int i = 0; i < moviesLength; i++) {
            MovieData movie = new MovieData(i, "Форсаж " + (i + 1), "криминал");
            manager.addMovie(movie);
        }

        for (int i = 0; i < expectedLength; i++) {
            expected[i] = manager.findById(moviesLength - 1 - i);
        }
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
