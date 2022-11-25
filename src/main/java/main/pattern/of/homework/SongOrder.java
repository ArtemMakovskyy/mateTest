package main.pattern.of.homework;

/**
 * Make possible initialization using static factory methods.
 * See requirements in task description.
 */
public class SongOrder {
    private String singer;
    private String songName;

    private SongOrder(String singer) {
        this.singer = singer;
//        System.out.println("Play any Bon Jovi song");
    }

    private SongOrder(String singer, String songName) {
        this.singer = singer;
        this.songName = songName;
//        System.out.println("Play Bon Jovi song called \"It's my life\"");
    }

    public static SongOrder of(String singer) {
        return new SongOrder(singer);
    }

    public static SongOrder of(String singer, String songName) {
        return new SongOrder(singer, songName);
    }

//    @Override
//    public String toString() {
//        return "SongOrder" +
//                "singer='" + singer + '\'' +
//                ", songName='" + songName + '\'';
//    }

    @Override
    public String toString() {
        if (songName==null && singer!= null){
           return  "Play any Bon Jovi song";
        }else {
            return "Play Bon Jovi song called \"It's my life\"";
        }
    }
}