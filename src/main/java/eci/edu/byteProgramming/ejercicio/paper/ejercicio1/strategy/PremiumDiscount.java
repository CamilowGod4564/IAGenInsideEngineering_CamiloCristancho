package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy;

import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.MembershipType;

public class PremiumDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(int subtotal, MembershipType membership) {
        // Premium gets 20% discount
        return subtotal * 0.20;
    }
}