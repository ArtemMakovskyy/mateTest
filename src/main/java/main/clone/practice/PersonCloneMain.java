package main.clone.practice;

public class PersonCloneMain {
    public static void main(String[] args) {
        Person artem = new Person("Arem",new Street("poleva",15));
        System.out.println(artem);

        Person cloneArtem = artem.clone();
        System.out.println(cloneArtem + "cloneArtem");
        System.out.println("...............Changing data");

        cloneArtem.setName("Ivan");
        cloneArtem.setStreet(new Street("Zalizn",16));
        cloneArtem.getStreet().setNameStreet("new name");


        System.out.println(artem);
        System.out.println(cloneArtem + "cloneArtem");
    }
}
