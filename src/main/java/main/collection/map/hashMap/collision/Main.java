package main.collection.map.hashMap.collision;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(10, 20);
        Rectangle rectangle2 = new Rectangle(10, 20);
        Map<Rectangle, Integer> map = new HashMap<>();
        map.put(rectangle1,100);
        System.out.println(map);
        System.out.println(map.get(rectangle2));

        System.out.println(" hash is " + hash(1000000));
    }
    static int hash(Object o){
        if (o==null) o = 0;
        int h = o.hashCode();
        int c = h>>>16;
        System.out.println("h>> " + c);
        return h;
    }
}
