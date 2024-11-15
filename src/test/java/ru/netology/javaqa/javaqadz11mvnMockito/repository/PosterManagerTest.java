package ru.netology.javaqa.javaqadz11mvnMockito.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void noFilms() {
        PosterManager manager = new PosterManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneFilm() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");

        String[] expected = {"1st Film"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void someFilms() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");

        String[] expected = {"1st Film", "Film 2nd", "3rd Film", "Film4th"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void underLimitFilms() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");

        String[] expected = {"Film4th", "3rd Film", "Film 2nd", "1st Film"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void underBoundaryLimitFilms() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");

        String[] expected = {"3rd Film", "Film 2nd", "1st Film"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LimitFilms() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");

        String[] expected = {"5th Film", "Film4th", "3rd Film", "Film 2nd", "1st Film"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void aboveLimitBoundaryFilms() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");
        manager.addPoster("Film 6th");

        String[] expected = {"Film 6th", "5th Film", "Film4th", "3rd Film", "Film 2nd"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void aboveLimitFilms() {
        PosterManager manager = new PosterManager();

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");
        manager.addPoster("Film 6th");
        manager.addPoster("Film7th");
        manager.addPoster("8th Film");

        String[] expected = {"8th Film", "Film7th", "Film 6th", "5th Film", "Film4th"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void underLimitQualityFilms() {
        PosterManager manager = new PosterManager(7);

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");

        String[] expected = {"Film4th", "3rd Film", "Film 2nd", "1st Film"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void underLimitQualityBoundaryFilms() {
        PosterManager manager = new PosterManager(7);

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");
        manager.addPoster("Film 6th");

        String[] expected = {"Film 6th", "5th Film", "Film4th", "3rd Film", "Film 2nd", "1st Film"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void limitQualityFilms() {
        PosterManager manager = new PosterManager(7);

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");
        manager.addPoster("Film 6th");
        manager.addPoster("Film7th");

        String[] expected = {"Film7th", "Film 6th", "5th Film", "Film4th", "3rd Film", "Film 2nd", "1st Film"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void aboveLimitQualityBoundaryFilms() {
        PosterManager manager = new PosterManager(7);

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");
        manager.addPoster("Film 6th");
        manager.addPoster("Film7th");
        manager.addPoster("8th Film");

        String[] expected = {"8th Film", "Film7th", "Film 6th", "5th Film", "Film4th", "3rd Film", "Film 2nd"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void aboveLimitQualityFilms() {
        PosterManager manager = new PosterManager(7);

        manager.addPoster("1st Film");
        manager.addPoster("Film 2nd");
        manager.addPoster("3rd Film");
        manager.addPoster("Film4th");
        manager.addPoster("5th Film");
        manager.addPoster("Film 6th");
        manager.addPoster("Film7th");
        manager.addPoster("8th Film");
        manager.addPoster("Film 9th");
        manager.addPoster("Film 10th");

        String[] expected = {"Film 10th", "Film 9th", "8th Film", "Film7th", "Film 6th", "5th Film", "Film4th"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

}