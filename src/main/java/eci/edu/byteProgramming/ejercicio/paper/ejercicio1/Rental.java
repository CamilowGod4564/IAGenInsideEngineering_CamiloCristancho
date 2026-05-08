package eci.edu.byteProgramming.ejercicio.paper.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private Customer customer;
    private List<Movie> movies;

    public Rental(Customer customer) {
        this.customer = customer;
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (movie.isAvailable()) {
            movies.add(movie);
            movie.setAvailable(false); // Mark as rented
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
        double discountRate = customer.getDiscountRate();
        return subtotal * discountRate;
    }

    public double calculateTotal() {
        return calculateSubtotal() - calculateDiscount();
    }

    public void printReceipt() {
        System.out.println("--- RENTAL RECEIPT ---");
        System.out.println("Customer: " + customer.getMembership());
        System.out.println("Movies:");
        for (Movie movie : movies) {
            System.out.println(" - " + movie.getTitle() + " (" + movie.getType() + ") - $" + movie.getPrice());
        }
        System.out.println("Subtotal: $" + calculateSubtotal());
        System.out.println("Discount (" + (int)(customer.getDiscountRate() * 100) + "%): $" + calculateDiscount());
        System.out.println("Total to pay: $" + calculateTotal());
        System.out.println("--------------------------");
        System.out.println("Enjoy your movie!");
    }
}