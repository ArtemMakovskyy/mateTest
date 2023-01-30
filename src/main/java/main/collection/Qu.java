package main.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Qu {
    public static void main(String[] args) {
//        qu();
//        dqu();
        stack();
    }
    private static void stack() {
        Stack<String>plates = new Stack<>();
        plates.add("plate1");
        plates.add("plate2");
        plates.add("plate3");
        plates.add("plate4");
        plates.add("plate5");
        plates.push("plate6");
        System.out.println(plates);
        System.out.println(plates.peek());
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        System.out.println(plates.pop());

        System.out.println(plates);
    }
    private static void dqu() {
        Deque<String> clients = new LinkedList<>();
        clients.add("Bob");
        clients.add("Alice");
        clients.add("John");
        System.out.println(clients);
//        System.out.println(clients.pollFirst());
//        System.out.println(clients.pollLast());
        System.out.println(clients.removeLast());
        System.out.println(clients.removeFirst());
        System.out.println(clients);
    }

    private static void qu() {
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
