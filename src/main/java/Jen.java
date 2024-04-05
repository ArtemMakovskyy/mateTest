import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Jen {
    public static void main(String[] args) {
        withoutJeneric();
        wildAndExtends();
        consumer();
    }

    private static void wildAndExtends() {
        List<Object> list2 = new ArrayList<>();
        list2.add('a');
        list2.add("fgsd");
        list2.add(1);
        list2.add(25.3);

        ArrayList<?> objects = new ArrayList<>(list2);
        objects.add(null);
        System.out.println(objects.get(2));
        System.out.println(objects);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        ArrayList<? extends Number> objects2 = new ArrayList<>(integers);
//        objects2.add(3);
        System.out.println(objects2);

    }

    private static void consumer(){
        ArrayList<? super String> strings = new ArrayList<>();
        strings.add("Привет");
        strings.add("Мир");


        for (Object obj : strings) {
            System.out.println(obj);
        }

        ArrayList<? super Number> numbers = new ArrayList<>();
        numbers.add(123); // Integer
        numbers.add(45.67); // Double
        numbers.add(new BigInteger("12345678901234567890")); // BigInteger

// Выводим все элементы списка
        for (Object obj : numbers) {
            System.out.println(obj);
        }

    }

    private static void withoutJeneric() {
        List list = new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0));

        List<Object> list2 = new ArrayList<>(list);
        list2.add(1);
        System.out.println(list2.get(0));
        System.out.println(list2.size());
    }
}
