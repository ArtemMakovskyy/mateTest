package tasks;

public class Likes {
    public static String whoLikesIt(String[] names) {
        int length = names.length;
        switch (length) {
            case 0:
                return "No one likes this";
            case 1:
                return names[0] + " likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default:
                return names[0] + ", " + names[1] + " and " + (length - 2) + " others like this";
        }
    }
}

//    whoLikesIt([]) ==> "No one likes this"
//        whoLikesIt(["Peter"]) ==> "Peter likes this"
//        whoLikesIt(["Jacob", "Alex"]) ==> "Jacob and Alex like this"
//        whoLikesIt(["Max", "John", "Mark"]) ==> "Max, John and Mark like this"
//        whoLikesIt(["Alex", "Jacob", "Mark", "Max"]) ==> "Alex, Jacob and 2 others like this"
