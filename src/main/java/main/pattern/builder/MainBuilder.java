package main.pattern.builder;

public class MainBuilder {
    public static void main(String[] args) {
//        Car car = new Car.Builder()
//                .setModel("audi")
//                .setHorsePower(5)
//                .setEngineVolume(4)
//                .build();
//        System.out.println(car);

//        Person person = new Person.Builder()
//                .setName("Artem")
//                .setAge(43)
//                .setSex("man")
//                .build();
//        System.out.println(person);
//
        Plane plane = new Plane.PlaneBuilder().setMinSpeed(25).setMaxSpeed(500).setMinSpeed(100).setBusinessClass(25).setNamePlane("may plaine").setSitsQuantity(30).build();
        System.out.println(plane);
    }
}
