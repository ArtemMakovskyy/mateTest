package main.collection.set;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked") // do not remove this line
public class StackWithArray<T> {
    private final static int BASE_CAPACITY = 16;
    private T[] arr;
    private int size;
    public String link = "https://www.techiedelight.com/ru/stack-implementation-in-java/";


    public StackWithArray() {
        arr = (T[]) new Object[BASE_CAPACITY];
    }

    public void push(T value) {
        arr[size] = value;
        size++;
    }

    public T peek() {
        if (size==0){
           throw new EmptyStackException();
        }
        return arr[size-1];
    }

    public T pop() {
        if (size==0){
            throw new EmptyStackException();
        }
        T element = arr[size-1];
        System.out.println(element);
        arr[size-1] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }
}
