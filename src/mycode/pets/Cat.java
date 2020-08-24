package mycode.pets;

public class Cat extends Pet {
    public String name;

    public Cat(String name, int paws, int tail) {
        this.name = name;
        this.paws = paws;
        this.tail = tail;
    }

    public void doATrick() {
        System.out.println(name + " does a trick");
    }

    public void meow() {
        System.out.println(name + " meows");
        System.out.println(name + " has " + paws + " paws and " + tail + " tail");

    }
}