package main;

import main.exception.UserNotFoundException;
import main.exception.UserService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] msg = new String[5];
        msg[0] = "abc1:1";
        msg[1] = "abc2:0";
        msg[2] = "abc3:2";
        msg[3] = "abc4:1";
        msg[4] = "abc5:3";

        String[] data = msg[0].split(":");
        System.out.println(data.length);
        System.out.println(Arrays.toString(data));

        for (String str : msg) {
            String[] data2 = str.split(";");
            System.out.print(Arrays.toString(data2) + " ");
        }
        System.out.println();

        for (String str : msg) {
            String[] data2 = str.split(":");
            if (data2[0].equals("abc3")){
                System.out.print(Arrays.toString(data2) + ", score is: ");
                System.out.println(Integer.parseInt(data2[1]));
            }
        }

        new UserService().getUserScore(data,"abc3");
    }
}
