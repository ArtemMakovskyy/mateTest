package main.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Qu {
    public static void main(String[] args) {
        Queue<String> buyers = new LinkedList<>();
        buyers.add("Bob");
        buyers.add("Alice");
        buyers.add("John");
        buyers.add("Bill");
        System.out.println(buyers);
        buyers.offer("Bruce");
        System.out.println(buyers);
        System.out.println(buyers.peek() + " peek");
        System.out.println(buyers.poll() + " poll");
        System.out.println(buyers);


    }
}
