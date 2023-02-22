package main.java8.optional.tasks;

import java.util.Optional;

public class GetOptionalValue {
    public Integer getOptionalValue(int randomNumber) {
        Optional<Integer> optional = generateRandomOptional(randomNumber);
        //write your code here
        return optional.orElseThrow();
    }

    public Optional<Integer> generateRandomOptional(int randomNumber) {
        if (randomNumber % 2 != 0 ) {
            return Optional.of(randomNumber);
        }
        return Optional.empty();
    }

    private final void inf() {
        /*
        Finish the implementation of generateRandomOptional()
        and getOptionalValue() methods.

        generateRandomOptional() should return Optional that holds
        randomNumber
        value - if randomNumber is odd, or empty

        Optional - if randomNumber is even.

        getOptionalValue() should call generateRandomOptional(),
        receive the Optional and return its value.
        If there is no value present - it should throw NoSuchElementException.
         */
    }
}
