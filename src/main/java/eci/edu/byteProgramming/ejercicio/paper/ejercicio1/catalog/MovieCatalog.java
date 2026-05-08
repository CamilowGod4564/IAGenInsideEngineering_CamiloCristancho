package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.catalog;


import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalog {
    private List<Movie> movies;

    public MovieCatalog() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    public Movie getMovieByIndex(int index) {
        if (index >= 0 && index < movies.size()) {
            return movies.get(index);
        }
        return null;
    }

    public void displayAvailableMovies() {
        System.out.println("Available movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println((i+1) + ". " + m + (m.isAvailable() ? " - Available" : " - NOT AVAILABLE"));
        }
    }
}