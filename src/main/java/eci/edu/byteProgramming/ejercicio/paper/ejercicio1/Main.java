package eci.edu.byteProgramming.ejercicio.paper.ejercicio1;


import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.catalog.MovieCatalog;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.*;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.receipt.ReceiptPrinter;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.rental.Rental;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy.BasicDiscount;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy.DiscountContext;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy.DiscountStrategy;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy.PremiumDiscount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize catalog
        MovieCatalog catalog = new MovieCatalog();
        catalog.addMovie(new PhysicalMovie("Interstellar", 8000, true));
        catalog.addMovie(new PhysicalMovie("The Godfather", 7000, false));
        catalog.addMovie(new DigitalMovie("Inception", 5000, true));
        catalog.addMovie(new DigitalMovie("Matrix", 6000, true));

        // Show movies
        catalog.displayAvailableMovies();

        // Get customer membership
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter customer membership (Basic/Premium): ");
        String membershipInput = scanner.nextLine();
        MembershipType membership = MembershipType.fromString(membershipInput);
        Customer customer = new Customer(membership);

        // Setup discount strategy
        DiscountStrategy strategy;
        if (membership == MembershipType.PREMIUM) {
            strategy = new PremiumDiscount();
        } else {
            strategy = new BasicDiscount();
        }
        DiscountContext discountContext = new DiscountContext(strategy);

        // Create rental
        Rental rental = new Rental(customer, discountContext);

        // Get movie selection
        System.out.print("Select movies (numbers separated by commas): ");
        String input = scanner.nextLine();
        String[] selections = input.split(",");

        for (String selection : selections) {
            int index = Integer.parseInt(selection.trim()) - 1;
            Movie selectedMovie = catalog.getMovieByIndex(index);
            if (selectedMovie != null) {
                rental.addMovie(selectedMovie);
            } else {
                System.out.println("Invalid selection: " + selection);
            }
        }

        // Print receipt
        System.out.println();
        ReceiptPrinter printer = new ReceiptPrinter();
        printer.printReceipt(rental);

        scanner.close();
    }
}