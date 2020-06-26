package main.java.com.javalessons.Interfaces;

public interface Pricable extends Deliverable,Orderable {

    default int calcPrice() {
    return calcOrderPrice() + calcDeliveryPrice();
}

}
