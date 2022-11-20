package main.pattern.builder;

public class Car {
    private String model;
    private int engineVolume;
    private int horsePower;

    private Car(Builder builder) {
        this.model = builder.model;
        this.engineVolume = builder.engineVolume;
        this.horsePower = builder.horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", horsePower=" + horsePower +
                '}';
    }

    public static class Builder {
        private String model;
        private int engineVolume;
        private int horsePower;

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setEngineVolume(int engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        public Builder setHorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
