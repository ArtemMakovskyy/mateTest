package main.java8.stream.classes.p_04;

import lombok.Getter;

@Getter
public class Phone {
    private String maker;
    private String model;
    private int memory;
    private double screenDiagonal;
    private int butteryLife;

    public Phone(Builder builder) {
        this.maker = builder.maker;
        this.model = builder.model;
        this.memory = builder.memory;
        this.screenDiagonal = builder.screenDiagonal;
        this.butteryLife = builder.butteryLife;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", memory=" + memory +
                ", screenDiagonal=" + screenDiagonal +
                ", butteryLife=" + butteryLife +
                '}';
    }
    public static class Builder{
        private String maker;
        private String model;
        private int memory;
        private double screenDiagonal;
        private int butteryLife;

        public Builder(String maker) {
            this.maker = maker;
        }

        public Builder setMaker(String maker) {
            this.maker = maker;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setMemory(int memory) {
            this.memory = memory;
            return this;
        }

        public Builder setScreenDiagonal(double screenDiagonal) {
            this.screenDiagonal = screenDiagonal;
            return this;
        }

        public Builder setButteryLife(int butteryLife) {
            this.butteryLife = butteryLife;
            return this;
        }
        public Phone build(){
            return new Phone(this);
        }
    }
}
