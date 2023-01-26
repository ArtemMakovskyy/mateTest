package main.clone.lesson.ed;

public class Education {
    public static void main(String[] args) {
        Human human = new Human("m", "Artem", 43, new Address());
        Human cloneHuman = human.clone();

        System.out.println(human);
        System.out.println(cloneHuman);
        human.setAge(44);
        human.setName("Ivan");
        System.out.println(human);
        System.out.println(cloneHuman);

    }
}
