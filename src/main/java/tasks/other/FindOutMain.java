package tasks.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindOutMain {
    public static void main(String[] args) {
        ArrayList<String>list = new ArrayList<>(List.of("b","g","h","i","f","c","a","d"));
        System.out.println(list);
        list.stream().sorted().forEach(System.out::print);
        System.out.println(list);
        System.out.println();
        Collections.sort(list, String::compareTo);
        System.out.println(list);
        int i = Integer.parseInt("25");

    }
}
