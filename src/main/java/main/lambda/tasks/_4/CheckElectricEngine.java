package main.lambda.tasks._4;

import java.util.function.Predicate;

public class CheckElectricEngine implements Predicate<Engine> {
    @Override
    public boolean test(Engine engineType) {
        return engineType.getEngineType().equals(Engine.EngineType.ELECTRIC);
    }
}
