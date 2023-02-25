package main.SOLID._03_LSP_2;

import main.SOLID._03_LSP_2.model.Bird;
import main.SOLID._03_LSP_2.model.FlyingBird;
import main.SOLID._03_LSP_2.model.Ostrich;
import main.SOLID._03_LSP_2.model.Parrot;

public class MainLSP {
    public static void main(String[] args) {
        FlyingBird parrot = new Parrot();
        Bird ostrich = new Ostrich();

        FlyingBird[] birds = new FlyingBird[]{parrot};
        Bird[]birds1 = new Bird[]{parrot,ostrich};

        for (FlyingBird bird : birds) {
            bird.fly();
            bird.dance();
        }
        System.out.println("----------------");
        for (Bird bird : birds1) {
            bird.dance();
        }

    }
}
