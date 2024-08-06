import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("John", 30);

        try {
            String json = objectMapper.writeValueAsString(user);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

@Data
class User {
    private String name;
    private int age;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}