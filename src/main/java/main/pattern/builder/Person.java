package main.pattern.builder;

public class Person {
    private String name;
    private int age;
    private String sex;

    public Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }


    public static class Builder {
        private String name;
        private int age;
        private String sex;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
}
