package main.exception;

public class UserService {
    public int getUserScore(String[] records, String email) {
        for (String record : records) {
            String[] data = record.split(":");
            if (data[0].equals(email)) {
                return Integer.parseInt(data[1]);
            }
        }
        throw new UserNotFoundRuntimeExceptionUnchecked("User with given email doesn't exist");
    }
}
class UserNotFoundRuntimeExceptionUnchecked extends RuntimeException {
    public UserNotFoundRuntimeExceptionUnchecked(String message) {
        super(message);
    }
}