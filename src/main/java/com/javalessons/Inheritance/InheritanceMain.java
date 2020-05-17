package com.javalessons.Inheritance;

public class InheritanceMain {

    public static void main(String[] args) {

        Engine truckengine = new Engine(6.0, EngineType.DIESEL, 900);
        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 150);
        Auto bus = new Bus("Mercedes", "Sprinter", busEngine, 50, 70, 12);
        Auto truck = new Truck("Volvo", "VNL 300", truckengine, 300, 500, 1000);
        Auto car = new ElectricCar("Tesla", "Model S", 4, 5);
        Auto auto = new Auto("MV","Polo",busEngine);


        runCar(bus);
        runCar(truck);
        runCar(car);
        runCar(auto);


    }

    private static void runCar(Auto auto) {
        auto.start();
        auto.stop();
        if(auto instanceof FuelAuto) {
            FuelAuto fAuto = (FuelAuto) auto;
            fAuto.fuelUp(50);
        }
    }

}
