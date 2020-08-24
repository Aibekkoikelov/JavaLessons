package mycode.pets;

public class Main {

    public static void main(String[] args) {

        Dog sharik = new Dog("sharik", 4, 1);
        sharik.doATrick();
        sharik.bark();
        sharik.setSize(PetSize.BIG);

        Dog tuzik = new Dog("tuzik", 4, 1);
        tuzik.doATrick();
        tuzik.bark();

        Cat murka = new Cat("Murka", 4, 1);
        murka.setSize(PetSize.SMALL);
        murka.doATrick();
        murka.meow();

        System.out.println("There are " + Pet.petCount + " pets");

    }


}
