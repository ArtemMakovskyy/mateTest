package main.lambda;

import java.util.Random;
import java.util.function.Supplier;

public class Supp_r {
    public static void main(String[] args) {
        Supplier<Integer>integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };
        Supplier<Integer>integerSupplierLambda = () -> new Random().nextInt();

        System.out.println(integerSupplierLambda.get() + ", " + integerSupplier.get());
    }
}
