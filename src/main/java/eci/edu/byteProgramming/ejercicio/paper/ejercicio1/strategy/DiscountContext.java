package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy;

import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.MembershipType;

public class DiscountContext {
    private DiscountStrategy strategy;

    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateDiscount(int subtotal, MembershipType membership) {
        return strategy.calculateDiscount(subtotal, membership);
    }
}