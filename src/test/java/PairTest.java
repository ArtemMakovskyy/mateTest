import java.lang.reflect.Method;
import java.util.Objects;

import main.jeneric.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PairTest {
    private Pair<Integer, String> firstPair;
    private Pair<Integer, String> secondPair;
    private Pair<Integer, String> thirdPair;

    @Before
    public void init() {
        firstPair = new Pair<>(5, "Five");
        secondPair = new Pair<>(2, "Two");
        thirdPair = new Pair<>(5, "Five");
    }

    @Test
    public void methodsCheck() {
        Class<Pair> pairClass = Pair.class;
        Method[] methods = pairClass.getDeclaredMethods();
        Assert.assertEquals("Not all methods were implemented\n", true,
                methods.length >= 4);
        int requiredMethodsCount = 0;
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("hashCode") ||
                    method.getName().equalsIgnoreCase("equals") ||
                    method.getName().equalsIgnoreCase("getKey") ||
                    method.getName().equalsIgnoreCase("getValue")) {
                requiredMethodsCount++;
            }
        }
        Assert.assertEquals("Not all required methods are implemented!\n", true,
                requiredMethodsCount >= 4);
    }

    @Test
    public void pairsAreEqual() {
        boolean actualResult = firstPair.equals(thirdPair);
        Assert.assertEquals("The result should be true after comparing two identical pairs\n",
                true, actualResult);
    }

    @Test
    public void pairsAreEqualWithNullParameter() {
        Pair<Object, Object> firstPair = new Pair<>(null, null);
        Pair<Object, Object> secondPair = new Pair<>(null, null);
        boolean actualResult = firstPair.equals(secondPair);
        Assert.assertEquals("The result should be true after comparing two identical "
                        + "(null, null) pairs\n",
                true, actualResult);
    }

    @Test
    public void pairsAreNotEqual() {
        boolean actualResult = firstPair.equals(secondPair);
        Assert.assertEquals("The result should be false after comparing two different pairs\n",
                false, actualResult);
    }

    @Test
    public void pairsAreNotEqualWithNullParameter() {
        Pair<Integer, String> firstPairWithNullParameter = new Pair<>(null, null);
        boolean actualFirstResult = firstPair.equals(firstPairWithNullParameter);
        boolean actualSecondResult = firstPairWithNullParameter.equals(firstPair);
        Assert.assertEquals("The result should be false after comparing "
                        + "pair with non-null elements inside and (null, null) pair\n",
                false, actualFirstResult);
        Assert.assertEquals("The result should be false after comparing "
                        + "pair with non-null elements inside and (null, null) pair\n",
                false, actualSecondResult);
    }

    @Test
    public void pairsAreEqualWithComplicatedParameter() {
        Person firstPerson = new Person("Name", "Surname");
        Person secondPerson = new Person("Name", "Surname");
        Address firstAddress = new Address("Street", 1);
        Address secondAddress = new Address("Street", 1);
        Pair<Person, Address> firstPair = new Pair<>(firstPerson, firstAddress);
        Pair<Person, Address> secondPair = new Pair<>(secondPerson, secondAddress);
        boolean actualResult = firstPair.equals(secondPair);

        Assert.assertEquals("The result should be true after comparing two identical pairs\n",
                true, actualResult);
    }

    @Test
    public void pairsAreNotEqualWithComplicatedParameter() {
        Person firstPerson = new Person("Name1", "Surname1");
        Person secondPerson = new Person("Name2", "Surname2");
        Address firstAddress = new Address("Street1", 1);
        Address secondAddress = new Address("Street2", 1);
        Pair<Person, Address> firstPair = new Pair<>(firstPerson, firstAddress);
        Pair<Person, Address> secondPair = new Pair<>(secondPerson, secondAddress);
        boolean actualResult = firstPair.equals(secondPair);

        Assert.assertEquals("The result should be false after comparing two different pairs\n",
                false, actualResult);
    }

    @Test
    public void sameObjectHashCodeEqualityTest() {
        Assert.assertEquals("Calling hashCode() for the same pair does not return the same result \n",
                firstPair.hashCode(), firstPair.hashCode());
        Assert.assertEquals("Calling hashCode() for the same pair does not return the same result \n",
                secondPair.hashCode(), secondPair.hashCode());
        Assert.assertEquals("Calling hashCode() for the same pair does not return the same result \n",
                thirdPair.hashCode(), thirdPair.hashCode());
    }

    @Test
    public void sameObjectHashCodeEqualityWithNullParametersTest() {
        Pair<Object, Object> firstPair = new Pair<>(null, null);
        Pair<Object, Object> secondPair = new Pair<>(null, null);
        Assert.assertEquals("Calling hashCode() for the same pair does not return the same result \n",
                firstPair.hashCode(), secondPair.hashCode());
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(String.format("Hash codes should be equal "
                        + "for firstPair(%d, %s), secondPair(%d, %s)\n", 5, "Five", 5, "Five"),
                firstPair.hashCode(), thirdPair.hashCode());
        Assert.assertNotEquals(String.format("Hash codes should not be equal "
                        + "for firstPair(%d, %s), secondPair(%d, %s)\n", 5, "Five", 2, "Two"),
                firstPair.hashCode(), secondPair.hashCode());
    }

    @Test
    public void getKeyMethodTest() {
        Assert.assertEquals(Integer.valueOf(5), firstPair.getKey());
        Assert.assertEquals(Integer.valueOf(2), secondPair.getKey());
    }

    @Test
    public void getValueMethodTest() {
        Assert.assertEquals("Five", firstPair.getValue());
        Assert.assertEquals("Two", secondPair.getValue());
    }

    @Test
    public void pairsAreNotEqualBySecondParameter() {
        Pair<String, Integer> firstPair = new Pair<>("5", 20);
        Pair<String, Integer> secondPair = new Pair<>("5", 30);

        Assert.assertNotEquals("Test failed with first hash "
                + firstPair.hashCode()
                + " and second hash " + secondPair.hashCode()
                + " and equals " + firstPair.equals(secondPair) + "\n", firstPair, secondPair);
    }

    @Test
    public void pairsAreNotEqualByFirstParameter() {
        Pair<String, Integer> firstPair = new Pair<>("5", 20);
        Pair<String, Integer> secondPair = new Pair<>("10", 20);

        Assert.assertNotEquals("Test failed with first hash "
                + firstPair.hashCode()
                + " and second hash " + secondPair.hashCode()
                + " and equals " + firstPair.equals(secondPair) + "\n", firstPair, secondPair);
    }

    public static class Address {
        private final String street;
        private final int houseNumber;

        public Address(String street, int houseNumber) {
            this.street = street;
            this.houseNumber = houseNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return houseNumber == address.houseNumber &&
                    Objects.equals(street, address.street);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, houseNumber);
        }
    }

    public static class Person {
        private final String name;
        private final String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(surname, person.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname);
        }
    }
}
