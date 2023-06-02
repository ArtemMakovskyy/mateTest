package tasks.other;

import java.security.Key;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

public class MainCollections {
    public static void main(String[] args) {
        List<Integer> integers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 9));
        System.out.println(integers1.subList(2, integers1.size()-2));
        LinkedList<Integer> integers = new LinkedList<>(integers1);
        Iterator<Integer> integerIterator = integers.descendingIterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
    }

    static void iterPrev() {
        List<Integer> integers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 9));
        List<Integer> integers2 = new ArrayList<>(List.of(4, 5, 6, 7, 8));
//        meth4(integers1, integers2);

        ListIterator<Integer> it = integers1.listIterator();
        System.out.println(it.hasNext());
        while (it.hasPrevious()) {
            Integer previous = it.previous();
            System.out.println(previous);
        }
    }
    static void iter() {
        List<String> arrayList = Arrays.asList("A", "B", "C", "D");


        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
//            String element =
                    listIterator.next();
//            listIterator.set(element + "+");
//            System.out.println(element);
        }


        System.out.print("Измененный arrayList в обратном порядке: ");
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            System.out.print(element + " ");
        }
    }
    private static <T> void meth4(Collection<T> a, Collection<T> b) {
        List<T> remove = new ArrayList<>(a);
        remove.removeAll(b);
        System.out.println(remove + " after removing");

        List<T> retain = new ArrayList<>(a);
        retain.retainAll(b);
        System.out.println(retain + " after retaining");

    }

    static void meth3() {
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3));
        Object[] objects = integerList.toArray();
        Integer[] integers = integerList.toArray(new Integer[integerList.size()]);
    }

    static void meth2() {
        Map<String, Integer> map = new HashMap<>(Map.of("one", 1, "two", 2, "three", 3));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        Set<String> strings2 = new HashSet<>();
        strings2.add("afsd");
        boolean afsd = strings2.contains("afsd");

    }

    static void meth1() {
        List<Integer> integers = Collections.synchronizedList(List.of(1, 2, 23, 4, 45));
//        integers.add(5);


        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue3 = new SynchronousQueue<>();
        Queue<Integer> queue4 = new ArrayDeque<>();
        Queue<Integer> queue5 = new ArrayBlockingQueue<>(10);
        Queue<Integer> queue6 = new ConcurrentLinkedQueue<>();

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
