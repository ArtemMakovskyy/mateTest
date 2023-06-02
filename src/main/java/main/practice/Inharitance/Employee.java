package main.practice.Inharitance;

import java.util.Objects;

public class Employee extends People{
    String department;

    public Employee(String name, String serName, String age, String department) {
        super(name, serName, age);
        this.department = department;
    }
    public static String show(String d){
        System.out.println("i shiw you " + d);
        return d;
    }
    public Employee(String department) {
        this.department = department;
    }
    public Employee() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + super.getName() + '\'' +
                ", serName='" + super.getSerName() + '\'' +
                ", age='" + super.getAge() + '\'' +
                '}' + "Employee{" +
                "department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDepartment());
    }
}
