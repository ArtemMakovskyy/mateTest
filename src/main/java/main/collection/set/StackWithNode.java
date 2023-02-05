package main.collection.set;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked") // do not remove this line
public class StackWithNode<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T oldValue = top.value;
        top = top.next;
        size--;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
