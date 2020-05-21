package MyCode.Pets;

public enum PetSize {
    SMALL("S"), MEDIUM("S"), BIG("L"), HUGE("XL");

    PetSize(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    final private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

}
