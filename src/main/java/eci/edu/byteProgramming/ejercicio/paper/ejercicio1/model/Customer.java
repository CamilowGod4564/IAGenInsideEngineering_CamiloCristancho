package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model;

public class Customer {
    private MembershipType membership;

    public Customer(MembershipType membership) {
        this.membership = membership;
    }

    public MembershipType getMembership() {
        return membership;
    }

    public double getDiscountRate() {
        return membership.getDiscountRate();
    }
}