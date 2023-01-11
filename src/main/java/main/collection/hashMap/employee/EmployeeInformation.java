package main.collection.hashMap.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeInformation {
    public List<Employee> getEmployeesByCityAndYearOfBirth(
            Map<Employee, String> employeesInformation, int yearOfBirth, String city) {
        List<Employee> employeeList = new ArrayList<>();
        for (Map.Entry<Employee, String> item : employeesInformation.entrySet()) {
            if (yearOfBirth <= item.getKey().getYearOfBirth()
                    && city.equals(item.getValue())) {
                employeeList.add(item.getKey());
            }
        }
        return employeeList;
    }
}
