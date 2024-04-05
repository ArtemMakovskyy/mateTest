package main.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sinc {
    public static void main(String[] args) {
        List<String >stringList = new ArrayList<>();
        stringList.add("jhgj");
        List<String >strings = Collections.synchronizedList(stringList);
    }
}
