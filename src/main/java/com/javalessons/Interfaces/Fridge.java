package main.java.com.javalessons.Interfaces;

public class Fridge extends Electronics{

    public Fridge(String name, String model, int quantity, int price) {
        super(name, model, quantity, price);
    }

    @Override
    public int calcDeliveryPrice() {
        if(getPrice()>=300) {
            return 0;
        } else {
            return 25;
        }
    }


}
