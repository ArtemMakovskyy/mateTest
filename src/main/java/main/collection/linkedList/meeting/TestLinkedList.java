package main.collection.linkedList.meeting;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) {
        List<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.set(4,111);
        System.out.println(ll);
        System.out.println(ll.size());


    }
}
