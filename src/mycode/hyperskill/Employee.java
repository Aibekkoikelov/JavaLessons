package mycode.hyperskill;

class Employee {

    String name;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }

    String email;
    int experience;

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }
}

class Developer extends Employee {

    public String getMainLanguage() {
        return mainLanguage;
    }
    public String[] getSkills() {
        return skills;
    }


    String mainLanguage;
    String[] skills;
    String[] newSkills = skills.clone();

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }
}

class DataAnalyst extends Employee {

    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }

    boolean phd;
    String[] methods;

    public DataAnalyst(String name, String emeil, int experience, boolean phd, String[] methods) {
        super(name, emeil, experience);
        this.phd = phd;
        this.methods = methods;
    }
}
