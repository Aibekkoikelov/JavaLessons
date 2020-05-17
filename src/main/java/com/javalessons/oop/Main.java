package com.javalessons.oop;

public class Main {

    public static void main(String[] args) {

        System.out.println("Dog's count " + Dog.getDogsCount());

        Dog lab = new Dog();
        lab.setName("Charlie");
        lab.setBreed("Lab");
        lab.setSize(Size.AVERAGE);
        lab.bite();

        Dog Sheppard = new Dog();
        Sheppard.setName("Mike");
        Sheppard.setBreed("Sheppard");
        Sheppard.setSize(Size.BIG);
        Sheppard.bite();

        Dog doberman = new Dog();
        doberman.setName("Jack");
        doberman.setBreed("Doberman");
        doberman.setSize(Size.BIG);
        doberman.bite();


        Size s = Size.SMALL;
        Size s1 = Size.valueOf("BIG");



        Size[] values = Size.values();
        for (int i = 0; i<values.length; i++) {
            System.out.println(values[i]);
        }

    }


}
