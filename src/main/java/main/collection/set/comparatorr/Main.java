package main.collection.set.comparatorr;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee("W",4,"m","1231");
        Employee employee2 = new Employee("B",5,"m","1233");
        Employee employee3 = new Employee("B",3,"w","1232");
        Employee employee4 = new Employee("A",1,"m","1234");
        Set<Employee>employeeSet = Set.of(employee1,employee2,employee3,employee4);
        List<Employee> employeeList = List.of(employee1,employee2,employee3,employee4);
        System.out.println(employeeList);
        Set<Employee> employeesByOrder = employeeService.getEmployeesByOrder(employeeList);
        System.out.println(employeesByOrder);
    }
}
