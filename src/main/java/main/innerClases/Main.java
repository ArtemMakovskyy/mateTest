package main.innerClases;

import main.innerClases.builder_static.People;
import main.innerClases.non_static.Non_Static;

public class Main {
    public static void main(String[] args) {
        // 1) Inner public static nested class
        People peopleStatic = new People.PeopleBuilder().setName("Artem").setAge(43).build();

        // 2) Inner public non-static class
        /* when we want to get non-static fields our father class */
        Non_Static non_static = new Non_Static();
        Non_Static.Node nodeNonStaticInner = non_static.new Node();
        nodeNonStaticInner.setValue("value");
        non_static.setKey("key");
        System.out.println(nodeNonStaticInner);
    }
}
