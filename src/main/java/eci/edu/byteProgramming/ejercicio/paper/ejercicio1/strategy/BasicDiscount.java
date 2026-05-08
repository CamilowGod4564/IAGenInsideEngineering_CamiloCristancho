package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy;

import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.MembershipType;

public class BasicDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(int subtotal, MembershipType membership) {
        return subtotal * membership.getDiscountRate();
    }
}