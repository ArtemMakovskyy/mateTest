package main.collection.linkedList.meeting;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private void add(T value) {
        new Node<T>( null, value, null);
    }

     static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
