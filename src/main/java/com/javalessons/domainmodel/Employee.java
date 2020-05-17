package com.javalessons.domainmodel;

public class Employee {

    private static int id = 1000;
    private int employeeId;
    private String name;
    private String position;
    private int salary;
    private String department;

    static {
        id = 1001;
        System.out.println("Static init block called");
    }

    {
        department = "IT";
        System.out.println("Non static init block called");
    }






    public Employee() {
        this("A", "B", 1);
        System.out.println(toString());
        System.out.println("empty parameters called");
    }

    public Employee(String name, String position, int salary) {
        this(name, position, salary, "IT");
        System.out.println("COnstructor with 3 parameners called");

    }

    private Employee(String employeeName, String position, int salary, String department) {
        employeeId = id++;
//        this.employeeName = name;
        this.name = employeeName;
        this.position = position;
        this.salary = salary;
        this.department = department;
        System.out.println("Constructor with 4 params called");
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
