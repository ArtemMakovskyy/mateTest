package main.innerClases.builder_static;

public class People {
    private String name;
    private int age;

    public People(PeopleBuilder builder) {
        this.name = builder.name;
        this.age  = builder.age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class PeopleBuilder{
        private String name;
        private int age;

        public PeopleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PeopleBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public People build(){
            return new People(this);
        }
    }
}
