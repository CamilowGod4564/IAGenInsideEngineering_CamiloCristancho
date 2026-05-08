package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.rental;


import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.Customer;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.Movie;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy.DiscountContext;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private Customer customer;
    private List<Movie> movies;
    private DiscountContext discountContext;

    public Rental(Customer customer, DiscountContext discountContext) {
        this.customer = customer;
        this.movies = new ArrayList<>();
        this.discountContext = discountContext;
    }

    public void addMovie(Movie movie) {
        if (movie.isAvailable()) {
            movies.add(movie);
            movie.setAvailable(false);
        } else {
            System.out.println("Sorry, " + movie.getTitle() + " is not available.");
        }
    }

    public int calculateSubtotal() {
        int subtotal = 0;
        for (Movie movie : movies) {
            subtotal += movie.getPrice();
        }
        return subtotal;
    }

    public double calculateDiscount() {
        int subtotal = calculateSubtotal();
        return discountContext.calculateDiscount(subtotal, customer.getMembership());
    }

    public double calculateTotal() {
        return calculateSubtotal() - calculateDiscount();
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public Customer getCustomer() {
        return customer;
    }
}