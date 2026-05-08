package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model;

public class PhysicalMovie extends Movie {
    public PhysicalMovie(String title, int price, boolean available) {
        super(title, price, available);
    }

    @Override
    public String getType() {
        return "Physical";
    }
}