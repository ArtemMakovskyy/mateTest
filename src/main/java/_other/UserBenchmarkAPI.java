package _other;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UserBenchmarkAPI {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String URL = "https://api.userbenchmark.com/data";

    public static void main(String[] args) {
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner sc = new Scanner(conn.getInputStream());
                while (sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
                sc.close();
            } else {
                System.out.println("Failed to get data");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
