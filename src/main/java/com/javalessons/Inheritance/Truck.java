package main.java.com.javalessons.Inheritance;

public class Truck extends FuelAuto {

    private int cargoWeight;

    public Truck(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int cargoWeight) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.cargoWeight = cargoWeight;
        System.out.println("Constructing truck");

    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Truck is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Truck has stopped");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePetrol());

    }
}
