package main.collection.set.comparatorr;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmployeeServiceTest {
    private static EmployeeService employeeService;
    private static final List<Employee> employeesOfDifferentAges = new ArrayList<>();
    private static final List<Employee> employeesOfSameAges = new ArrayList<>();
    private static final List<Employee> employeesOfDifferentAgesAndNames = new ArrayList<>();
    private static Employee alice;
    private static Employee bob;
    private static Employee jack;
    private static Employee ella;
    private static Employee nicolas;
    private static Employee john;
    private static Employee james;
    private static Employee anna;

    @BeforeClass
    public static void setUp() {
        employeeService = new EmployeeService();
        initializeEmployees();
        initializeEmployeesOfDifferentAges();
        initializeEmployeesOfSameAges();
        initializeEmployeesOfTheSameAges();
    }

    @Test
    public void getEmployeesByOrder_sortByAge() {
        Set<Employee> actualResult = employeeService.getEmployeesByOrder(employeesOfDifferentAges);
        Assert.assertEquals("The size of sorted set should the same as the size of input list\n",
                employeesOfDifferentAges.size(), actualResult.size());

        Iterator<Employee> iterator = actualResult.iterator();
        Employee firstActualEmployee = iterator.next();
        Assert.assertEquals("The first employee in the set should be - " + bob + "\n",
                bob, firstActualEmployee);

        Employee secondActualEmployee = iterator.next();
        Assert.assertEquals("The second employee in the set should be - " + alice + "\n",
                alice, secondActualEmployee);

        Employee thirdActualEmployee = iterator.next();
        Assert.assertEquals("The third employee in the set should be - " + ella + "\n",
                ella, thirdActualEmployee);

        Employee fourthActualEmployee = iterator.next();
        Assert.assertEquals("The fourth employee in the set should be - " + nicolas + "\n",
                nicolas, fourthActualEmployee);
    }

    @Test
    public void getEmployeesByOrder_sortByName() {
        Set<Employee> actualResult = employeeService.getEmployeesByOrder(employeesOfSameAges);
        Assert.assertEquals("The size of sorted set should the same as the size of input list\n",
                employeesOfSameAges.size(), actualResult.size());

        Iterator<Employee> iterator = actualResult.iterator();
        Employee firstActualEmployee = iterator.next();
        Assert.assertEquals("The first employee in the set should be - " + jack + "\n",
                jack, firstActualEmployee);

        Employee secondActualEmployee = iterator.next();
        Assert.assertEquals("The second employee in the set should be - " + james + "\n",
                james, secondActualEmployee);

        Employee thirdActualEmployee = iterator.next();
        Assert.assertEquals("The third employee in the set should be - " + john + "\n",
                john, thirdActualEmployee);
    }

    @Test
    public void getEmployeesByOrder_sortByAgeAndName() {
        Set<Employee> actualResult = employeeService.getEmployeesByOrder(employeesOfDifferentAgesAndNames);
        Assert.assertEquals("The size of sorted set should the same as the size of input list\n",
                employeesOfDifferentAgesAndNames.size(), actualResult.size());

        Iterator<Employee> iterator = actualResult.iterator();
        Employee firstActualEmployee = iterator.next();
        Assert.assertEquals("The first employee in the set should be - " + bob + "\n",
                bob, firstActualEmployee);

        Employee secondActualEmployee = iterator.next();
        Assert.assertEquals("The second employee in the set should be - " + alice + "\n",
                alice, secondActualEmployee);

        Employee thirdActualEmployee = iterator.next();
        Assert.assertEquals("The third employee in the set should be - " + anna + "\n",
                anna, thirdActualEmployee);

        Employee fourthActualEmployee = iterator.next();
        Assert.assertEquals("The fourth employee in the set should be - " + jack + "\n",
                jack, fourthActualEmployee);

        Employee fifthActualEmployee = iterator.next();
        Assert.assertEquals("The fifth employee in the set should be - " + james + "\n",
                james, fifthActualEmployee);

        Employee sixthActualEmployee = iterator.next();
        Assert.assertEquals("The sixth employee in the set should be - " + john + "\n",
                john, sixthActualEmployee);

        Employee seventhActualEmployee = iterator.next();
        Assert.assertEquals("The seventh employee in the set should be - " + ella + "\n",
                ella, seventhActualEmployee);

        Employee eighthActualEmployee = iterator.next();
        Assert.assertEquals("The eighth employee in the set should be - " + nicolas + "\n",
                nicolas, eighthActualEmployee);
    }

    @Test
    public void getEmployeesByOrder_emptyList() {
        Set<Employee> actualResult = employeeService.getEmployeesByOrder(new ArrayList<>());
        Assert.assertEquals("The size of sorted set should the same as the size of input list\n",
                0, actualResult.size());
    }

    @Test
    public void getEmployeesByOrder_checkImplementComparable() {
        boolean actualResult = Comparable.class.isAssignableFrom(Employee.class);
        Assert.assertEquals("Your task is to create Comparator, "
                + "not implement Comparable interface.\n", false, actualResult);
    }

    private static void initializeEmployees() {
        alice = new Employee("Alice Adams", 22, "female", "12345678");
        bob = new Employee("Bob Allen", 20, "male", "02783927");
        jack = new Employee("Jack Baker", 23, "male", "72839164");
        ella = new Employee("Ella Ball", 25, "female", "26374910");
        nicolas = new Employee("Nicolas Brown", 27, "male", "53649103");
        john = new Employee("John Carter", 23, "male", "19203745");
        james = new Employee("James Clarke", 23, "male", "29103846");
        anna = new Employee("Anna Collins", 22, "female", "26172840");
    }

    private static void initializeEmployeesOfDifferentAges() {
        employeesOfDifferentAges.add(alice);
        employeesOfDifferentAges.add(bob);
        employeesOfDifferentAges.add(nicolas);
        employeesOfDifferentAges.add(ella);
    }

    private static void initializeEmployeesOfSameAges() {
        employeesOfSameAges.add(james);
        employeesOfSameAges.add(john);
        employeesOfSameAges.add(jack);
    }

    private static void initializeEmployeesOfTheSameAges() {
        employeesOfDifferentAgesAndNames.add(alice);
        employeesOfDifferentAgesAndNames.add(bob);
        employeesOfDifferentAgesAndNames.add(jack);
        employeesOfDifferentAgesAndNames.add(ella);
        employeesOfDifferentAgesAndNames.add(nicolas);
        employeesOfDifferentAgesAndNames.add(john);
        employeesOfDifferentAgesAndNames.add(james);
        employeesOfDifferentAgesAndNames.add(anna);
    }
}
