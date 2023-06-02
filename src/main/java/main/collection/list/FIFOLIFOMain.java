package main.collection.list;

import java.util.*;

public class FIFOLIFOMain {
    public static void main(String[] args) {
ll();
q();




    }
    static void calculateWithCache(int key) {
//        curTime = getCurrentTime();
//        // Если значение уже было в кэше вернем его
//        if (key in hashTable) {
//            // Сначала обновим время последнего запроса к key
//            timeQueue.set(key, curTime);
//            return hashTable[key];
//        }
//        // Иначе вычислим результат
//        result = calculate(key);
//
//        // Если в кэше уже N элементов, то вытесним самый старый
//        if (hashTable.length == N) {
//            minKey = timeQueue.extractMinValue();
//            hashTable.remove(minKey);
//        }
//
//        // Добавим в таблицу, и в очередь
//        hashTable.add(key, result);
//        timeQueue.add(key, curTime);
//
//        return result;
    }
    private static void dq(){
        Deque<Integer> integerDeque = new ArrayDeque<>(List.of(5, 6, 7, 8));


    }
    private static void q(){
        System.out.println();
        Queue<Integer> integerQueue = new LinkedList<>(List.of(5, 6, 7, 8));
        System.out.println(integerQueue);

        System.out.println("\n" + integerQueue.peek() + " peek");
        System.out.println(integerQueue);

        System.out.println(integerQueue.poll() + " poll");
        System.out.println(integerQueue);

        System.out.println(integerQueue.element() + " element");
        System.out.println(integerQueue);
    }
    private static void ll(){
        List<Integer> listinkedList = new LinkedList<>(List.of(1, 2, 3));
        listinkedList.add(4);
        System.out.println(listinkedList.get(0));
        System.out.println(listinkedList.get(listinkedList.size() - 1));
    }
}
