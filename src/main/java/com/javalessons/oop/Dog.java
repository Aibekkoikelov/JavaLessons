package main.java.com.javalessons.oop;

public class Dog {


    private static int dogsCount;

    public static final int PAWS = 4;
    public static final int TAIL = 1;
    private String name;
    private String breed;
    private Size size = Size.UNDEFINED;

    public Dog() {
        dogsCount++;
        System.out.println("Dog's count is " + dogsCount);
    }


    public static int getDogsCount() {
        return dogsCount;
    }


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
//        if (size.equalsIgnoreCase("big") ||
//                size.equalsIgnoreCase("average") ||
//                size.equalsIgnoreCase("small")) {
//            this.size = size;
//        } else {
//            System.out.println("Size should be one of these: Bug, Average or Small");
//        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark() {
        switch (size) {
            case BIG:
            case VERY_BIG:
                System.out.println("wof wof");
                break;
            case AVERAGE:
                System.out.println("raf raf");
                break;
            case SMALL:
            case VERY_SMALL:
                System.out.println("gaf gaf");
                break;
            default:
                System.out.println("dog's size undefined");
        }

    }

    public void bite() {
        if (dogsCount > 2) {
            System.out.println("Dog's are biting you");
        } else {
            bark();
        }
    }

}