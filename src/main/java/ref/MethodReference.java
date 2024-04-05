package ref;

public class MethodReference {
    public static void main(String[] args) {
        // Referring static method
        SayAble sayable = MethodReference::saySomething;
        SayAble sayAble2 = MethodReference::saySomething2;
        // Calling interface method
        sayable.say();
        sayAble2.say();


    }

    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }
    public static void saySomething2() {
        String [] str = new String[]{"Hello, ","this is static", " method."};
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
    }
}