package eci.edu.byteProgramming.ejercicio.paper.ejercicio1;

public class Customer {
        private String membership; // "Basic" or "Premium"

    public Customer(String membership) {
        this.membership = membership;
    }

    public String getMembership() {
        return membership;
    }

    public double getDiscountRate() {
        if (membership.equals("Premium")) {
            return 0.20; // 20% discount
        }
        return 0.0; // Basic: 0% discount
    }
}