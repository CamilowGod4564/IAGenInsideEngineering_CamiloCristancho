package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model;

public class DigitalMovie extends Movie {
    public DigitalMovie(String title, int price, boolean available) {
        super(title, price, available);
    }

    @Override
    public String getType() {
        return "Digital";
    }
}