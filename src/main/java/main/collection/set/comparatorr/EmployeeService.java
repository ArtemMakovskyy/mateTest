package main.collection.set.comparatorr;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeService {
    public Set<Employee> getEmployeesByOrder(List<Employee> employees) {
        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                int compareAge = Integer.compare(employee1.getAge(), employee2.getAge());
                return compareAge != 0 ? compareAge : employee1.getName().compareTo(employee2.getName());
            }
        };
        Set<Employee> employeeSet = new TreeSet<>(employeeComparator);
        employeeSet.addAll(employees);
        return employeeSet;
    }
}
