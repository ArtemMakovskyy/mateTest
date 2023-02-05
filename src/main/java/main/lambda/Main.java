package main.lambda;

public class Main {
    public static void main(String[] args) {
        NoElements noElements = () -> System.out.println("Hello");
        noElements.doAction();

        SingleElement singleElement = s -> System.out.println(s);
        singleElement.print("print one element");


        SingleElement singleElement2 = s -> {
            if (s == null) {
                System.out.println("NULL value");
            }
            singleElement.print(s);
        };    
        singleElement2.print(null);

        TwoElements twoElements = (a, b) -> a - b;
        System.out.println(twoElements.compare(25, 20));
    }
}
