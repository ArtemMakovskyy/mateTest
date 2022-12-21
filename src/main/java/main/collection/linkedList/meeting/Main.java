package main.collection.linkedList.meeting;

public class Main {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(null, 10, null);
        Node<Integer> node2 = new Node<>(node1, 20, null);
        node1.next = node2;
        Node<Integer> node3 = new Node<>(node2, 30, null);
        node2.next = node3;

        Node<Integer> currentNode = node1;
        while (currentNode != null) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
    }

    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

