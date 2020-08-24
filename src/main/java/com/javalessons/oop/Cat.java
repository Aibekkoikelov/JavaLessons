package main.java.com.javalessons.oop;

class Cat {

    String name;
    int age;
    static int counter;

    public Cat(String name, int age) {
        counter++;
        this.name = name;
        this.age = age;
        if (getNumberOfCats() > 5) {
            System.out.println("You have too many cats");
        }
        System.out.println(getNumberOfCats());
    }

    public static int getNumberOfCats() {
         return counter;
    }
}