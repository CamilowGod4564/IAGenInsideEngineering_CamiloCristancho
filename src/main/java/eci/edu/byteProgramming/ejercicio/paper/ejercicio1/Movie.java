package eci.edu.byteProgramming.ejercicio.paper.ejercicio1;

public class Movie {
    private String title;
    private String type;
    private int price;
    private boolean available;

    public Movie(String title, String type, int price, boolean available) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return title + " (" + type + ") - $" + price;
    }
}