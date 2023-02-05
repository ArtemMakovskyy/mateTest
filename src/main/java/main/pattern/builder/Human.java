package main.pattern.builder;

public class Human {
    private String name;
    private String serName;
    private int age;

    public Human(HumanBuilder humanBuilder) {
        this.name = humanBuilder.name;
        this.serName = humanBuilder.serName;
        this.age = humanBuilder.age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", serName='" + serName + '\'' +
                ", age=" + age +
                '}';
    }

    public static class HumanBuilder {
        private String name;
        private String serName;
        private int age;

        public HumanBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder setSerName(String serName) {
            this.serName = serName;
            return this;
        }

        public HumanBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Human build(){
            return new Human(this);
        }
    }
}
