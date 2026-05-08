package eci.edu.byteProgramming.ejercicio.paper.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Available movies
        List<Movie> availableMovies = new ArrayList<>();
        availableMovies.add(new Movie("Interstellar", "Physical", 8000, true));
        availableMovies.add(new Movie("The Godfather", "Physical", 7000, false));
        availableMovies.add(new Movie("Inception", "Digital", 5000, true));
        availableMovies.add(new Movie("Matrix", "Digital", 6000, true));

        // Show movies to user
        System.out.println("Available movies:");
        for (int i = 0; i < availableMovies.size(); i++) {
            Movie m = availableMovies.get(i);
            System.out.println((i+1) + ". " + m + (m.isAvailable() ? " - Available" : " - NOT AVAILABLE"));
        }

        // Get customer membership
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter customer membership (Basic/Premium): ");
        String membership = scanner.nextLine();

        Customer customer = new Customer(membership);
        Rental rental = new Rental(customer);


        System.out.print("Select movies (numbers separated by commas): ");
        String input = scanner.nextLine();
        String[] selections = input.split(",");

        for (String selection : selections) {
            int index = Integer.parseInt(selection.trim()) - 1;
            if (index >= 0 && index < availableMovies.size()) {
                Movie selectedMovie = availableMovies.get(index);
                rental.addMovie(selectedMovie);
            } else {
                System.out.println("Invalid selection: " + selection);
            }
        }

        // Print receipt
        System.out.println();
        rental.printReceipt();

        scanner.close();
    }
}