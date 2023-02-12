package main.lambda.tasks._3;

import java.util.function.Function;

public class FindAutoType implements Function<Integer, AutoType> {
    @Override
    public AutoType apply(Integer weight) {
        if (weight < 1500) {
            return AutoType.CAR;
        } else return AutoType.TRUCK;
    }
}
