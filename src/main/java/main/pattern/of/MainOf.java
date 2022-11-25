package main.pattern.of;

import lombok.Singular;
import main.pattern.of.homework.SongOrder;

public class MainOf {
    public static void main(String[] args) {
//        User user = User.of("Artem", 43);

        SongOrder songOrder = SongOrder.of("osdos") ;
        SongOrder songOrder2 = SongOrder.of("olala","osdos") ;
        System.out.println(songOrder);
//        System.out.println(songOrder2);
    }
}
