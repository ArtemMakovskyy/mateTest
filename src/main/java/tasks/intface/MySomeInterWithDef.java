package tasks.intface;

public interface MySomeInterWithDef {

    void show();
    default void print(){
        System.out.println("i'm print it... ");
    }
    static void blowHorn(){
        System.out.println("blow horn ");
    }

}

class SomeImpl implements MySomeInterWithDef{

    @Override
    public void show() {
        System.out.println("i wont to show you some thing");
    }

    @Override
    public void print() {
        MySomeInterWithDef.super.print();
    }
}
class Main{
    public static void main(String[] args) {
        SomeImpl some = new SomeImpl();
        some.print();
        some.show();
        MySomeInterWithDef.blowHorn();


    }
}