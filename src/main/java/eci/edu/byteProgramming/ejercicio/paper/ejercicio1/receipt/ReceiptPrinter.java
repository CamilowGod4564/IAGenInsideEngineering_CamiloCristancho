package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.receipt;


import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.Movie;
import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.rental.Rental;

public class ReceiptPrinter {
    public void printReceipt(Rental rental) {
        System.out.println("--- RENTAL RECEIPT ---");
        System.out.println("Customer: " + rental.getCustomer().getMembership().getDisplayName());
        System.out.println("Movies:");

        for (Movie movie : rental.getMovies()) {
            System.out.println(" - " + movie.getTitle() + " (" + movie.getType() + ") - $" + movie.getPrice());
        }

        System.out.println("Subtotal: $" + rental.calculateSubtotal());
        System.out.println("Discount (" + (int)(rental.getCustomer().getDiscountRate() * 100) + "%): $" + rental.calculateDiscount());
        System.out.println("Total to pay: $" + rental.calculateTotal());
        System.out.println("--------------------------");
        System.out.println("Enjoy your movie!");
    }
}