package lvm.memory;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        ObladaStatic.printOblada();
        String link1i = "https://javadevblog.com/tipy-ssy-lok-v-java-strongreference-weakreference-softreference-i-phantomreference.html";
        String link2i = "https://topjava.ru/blog/stack-and-heap-in-java";
        String link3i = "https://habr.com/ru/post/549176/";
        /*
        Сборщик мусора в Java чаще всего работает со Strong References
        или же сильными ссылками. Там все понятно и просто: создаем ссылку
        на объект, что-то делаем с ним и потом, когда ссылка будет
        указывать на null и других ссылок на этот объект не будет —
        освобождаем память.

        сборщик мусора освободит память объекта, если на него указывают
        только слабые ссылки. Когда на объект указывают ссылки SoftReferences,
        то освобождение памяти происходит, когда JVM сильно нуждается в памяти.
         */

//        Strong References - самые популярные ссылочные типы, к которым мы все привыкли
        StringBuilder stringBuilder = new StringBuilder();

//        Weak Reference
        WeakHashMap<Integer,Integer> hashMap = new WeakHashMap<>();
        hashMap.put(1,2);

        Student student = new Student();// слабая ссылка на него
        WeakReference<Student> weakStudent = new WeakReference<Student>(student);
        student = null; // теперь объект Student может быть собран сборщиком мусора

//        Soft Reference
        SoftReference<StringBuilder> reference = new SoftReference<>(new StringBuilder());
        Student student2 = new Student();// какой-то объект
        SoftReference<Student> softStudent = new SoftReference<Student>(student2); // слабая ссылка на него
// теперь объект Student может быть собран сборщиком мусора
// но это случится только в случае сильной необходимости JVM в памяти
        student2 = null;


        Student counterStudent = new Student(); // strong reference
        WeakReference weakCounter = new WeakReference(counterStudent); //weak reference
        counterStudent = null; // now Counter object is eligible for garbage collection

    }
}

class Student{}