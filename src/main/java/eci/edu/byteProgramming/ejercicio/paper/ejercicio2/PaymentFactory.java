package eci.edu.byteProgramming.ejercicio.paper.ejercicio2;


public interface PaymentFactory {
    PaymentMethod createPaymentMethod(double amount, String customerId, String description);
}