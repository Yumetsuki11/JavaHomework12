package ru.netology.poster.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import ru.netology.poster.domain.MovieData;

public class PosterManagerTest {
    PosterRepository repo = Mockito.mock(PosterRepository.class);
    PosterManager manager = new PosterManager(repo, 4);

    MovieData movie1 = new MovieData(1, "Форсаж 1", "криминал");
    MovieData movie2 = new MovieData(2, "Форсаж 2", "криминал");
    MovieData movie3 = new MovieData(3, "Форсаж 3", "криминал");
    MovieData movie4 = new MovieData(4, "Форсаж 4", "криминал");
    MovieData movie5 = new MovieData(5, "Форсаж 5", "криминал");

    @Test
    public void shouldFindLastWhenLimitLessThanLength() {
        MovieData[] movies = {movie1, movie2, movie3, movie4, movie5};
        doReturn(movies).when(repo).findAll();

        MovieData[] expected = {movie5, movie4, movie3, movie2};

        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
