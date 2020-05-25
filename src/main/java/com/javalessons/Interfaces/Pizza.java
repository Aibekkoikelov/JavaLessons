package main.java.com.javalessons.Interfaces;

public class Pizza implements Deliverable{

    private String name;
    private int quantity;
    private double price;
    private Size size;

    public Pizza(String name, int quantity, double price, Size size) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    @Override
    public void calcDeliveryPrice() {

    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }
}
