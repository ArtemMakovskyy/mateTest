package tasks.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Main {
    public static void main(String[] args) {
        String txt = "Artem Makovskyy";
        String encodeToString = Base64.getEncoder().encodeToString(txt.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeToString);
        byte[] decode = Base64.getDecoder().decode(encodeToString);

        String txt2 = new String(decode,StandardCharsets.UTF_8);
        System.out.println(txt2);
    }
}
