package main.practice;

public class Box {
    int b;

    public Box(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class Main{
    public static void main(String[] args) {
        int number;
        number = 10;
        System.out.println(number);
        changeNumber(20);
        System.out.println(number);
        Box box2 = new Box(10);
        System.out.println(box2.b);

    }
    static void objectMath(){
        Object o = new Object();
        Class<?> aClass = o.getClass();
    }
    static void changeBox(Box b){
//        main(new String[]{"1","2","3"});

    }
    static void changeNumber(int newNumber){
//        number = newNumber;

    }
}