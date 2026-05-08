package eci.edu.byteProgramming.ejercicio.paper.ejercicio1.model;

public abstract class Movie {
    protected String title;
    protected int price;
    protected boolean available;

    public Movie(String title, int price, boolean available) {
        this.title = title;
        this.price = price;
        this.available = available;
    }

    public String getTitle() {
        return title;
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

    public abstract String getType();

    @Override
    public String toString() {
        return title + " (" + getType() + ") - $" + price;
    }
}