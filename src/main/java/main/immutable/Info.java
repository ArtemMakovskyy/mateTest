package main.immutable;

public class Info {
    public Info() {
        info();
        homCreateImmutable();
    }

    public void info(){
        System.out.println("Immutable is: ");
        System.out.println(" - as a key in Map");
        System.out.println(" - multithreading");
        System.out.println(" - no side effect rule");
        System.out.println("... immutable are all wrap classes");
    }
    public void homCreateImmutable(){
        System.out.println("        *  1 final\n" +
                "        *  2 No setter. Only constructor\n" +
                "        *  3 return deep Copy\n" +
                "        *  4 return Deep clone\n" +
                "        *  5 clone the object and constructor");
        /*
        *  1 final
        *  2 No setter. Only constructor
        *  3 return deep Copy
        *  4 return Deep clone
        *  5 clone the object and constructor
        * */
    }
}
