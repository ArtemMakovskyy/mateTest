package main.pattern.builder;

public class Plane {
    private String namePlane;
    private int sitsQuantity;
    private int maxSpeed;
    private int minSpeed;
    private int businessClass;

    public String getNamePlane() {
        return namePlane;
    }

    public int getSitsQuantity() {
        return sitsQuantity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public int getBusinessClass() {
        return businessClass;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "namePlane='" + namePlane + '\'' +
                ", sitsQuantity=" + sitsQuantity +
                ", maxSpeed=" + maxSpeed +
                ", minSpeed=" + minSpeed +
                ", businessClass=" + businessClass +
                '}';
    }

    private Plane(PlaneBuilder planeBuilder) {
        this.namePlane = planeBuilder.namePlane;
        this.sitsQuantity = planeBuilder.sitsQuantity;
        this.maxSpeed = planeBuilder.maxSpeed;
        this.minSpeed = planeBuilder.minSpeed;
        this.businessClass = planeBuilder.businessClass;
    }

    public static class PlaneBuilder {
        private String namePlane;
        private int sitsQuantity;
        private int maxSpeed;
        private int minSpeed;
        private int businessClass;

        public PlaneBuilder setNamePlane(String namePlane) {
            this.namePlane = namePlane;
            return this;
        }

        public PlaneBuilder setSitsQuantity(int sitsQuantity) {
            this.sitsQuantity = sitsQuantity;
            return this;
        }

        public PlaneBuilder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public PlaneBuilder setMinSpeed(int minSpeed) {
            this.minSpeed = minSpeed;
            return this;
        }

        public PlaneBuilder setBusinessClass(int businessClass) {
            this.businessClass = businessClass;
            return this;
        }

        public Plane build() {
            return new Plane(this);
        }

        @Override
        public String toString() {
            return "PlaneBuilder{" +
                    "namePlane='" + namePlane + '\'' +
                    ", sitsQuantity=" + sitsQuantity +
                    ", maxSpeed=" + maxSpeed +
                    ", minSpeed=" + minSpeed +
                    ", businessClass=" + businessClass +
                    '}';
        }
    }
}
