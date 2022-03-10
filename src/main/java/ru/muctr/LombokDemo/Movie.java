package ru.muctr.LombokDemo;
import lombok.*;

import java.util.Arrays;
import java.util.Objects;


@AllArgsConstructor
public class Movie implements Comparable<Movie>{
    @Getter
    @Setter
    private final String title;
    private int year;
    private String producer;

    @Override
    public int compareTo(Movie o) {
        return getTitle().compareToIgnoreCase(o.getTitle());
    }
}

class DocMovie extends Movie {
    public DocMovie(String title, int year, String producer) {
        super(title, year, producer);
    }
}


