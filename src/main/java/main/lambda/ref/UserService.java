package main.lambda.ref;

@FunctionalInterface
public interface UserService {
    User of(String name);
}
