package MyCode.Pets;

public class Pet {
    private String name;
    public static int paws;
    public static int tail;
    public static int petCount;
    public PetSize size;

    public void setSize(PetSize size) {
        this.size = size;
    }

    public Pet() {
        petCount++;
    }
}

