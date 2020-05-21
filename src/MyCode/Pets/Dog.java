package MyCode.Pets;

public class Dog extends Pet {

    public String name;

    public Dog (String name, int paws, int tail) {
        this.name = name;
        this.paws = paws;
        this.tail = tail;
    }

    public void doATrick(){
        System.out.println(name+" does a trick");
    }
    public void bark() {
        System.out.println(name+" barks");
    }


}
