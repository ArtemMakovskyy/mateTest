package main.clone;

public class MainPerson {
    public static void main(String[] args) {
        Person artemM = new Person(
                new Name("Artem", "Makovskyy"),
                new Adress("Poleva", 15, 2));

        Person mother = artemM;

        System.out.println(artemM);
        System.out.println(mother);
        mother.setName(new Name("Lena", "Mak"));
        System.out.println("after clone");
        System.out.println(artemM);
        System.out.println(mother);

    }
}
