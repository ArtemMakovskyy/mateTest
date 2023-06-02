package main.pattern.singleton;

import java.nio.file.Path;

public class MainSingleton {
    public static void main(String[] args) {
        String path = "https://javarush.com/groups/posts/589-patternih-i-singleton--dlja-vsekh-kto-vpervihe-s-nimi-stolknulsja";
        LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();

    }
}
