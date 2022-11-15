package main.equal;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setStreet("Sheva");

        User bob = new User();
        bob.setName("Bob");
        bob.setLastName("Alison");
        bob.setAddress(address);

        System.out.println(bob);
        User clonedBob = bob.clone();
        bob.getAddress().setStreet("popova");
        System.out.println(clonedBob);
        System.out.println(bob);
    }
}
