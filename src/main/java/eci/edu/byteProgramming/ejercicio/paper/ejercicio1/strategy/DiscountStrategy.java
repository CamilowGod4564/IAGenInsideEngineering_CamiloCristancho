package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.strategy;

import eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model.MembershipType;

public interface DiscountStrategy {
    double calculateDiscount(int subtotal, MembershipType membership);
}