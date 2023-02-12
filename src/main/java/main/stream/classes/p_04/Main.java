package main.stream.classes.p_04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<Phone> phonesFromDB = getPhonesFromDB();
//        Stream<Phone> stream = phonesFromDB.stream(); // stream of phones
//        Stream<Phone> filteredByMakerMemory = stream.filter(phone -> phone.getMaker()
//                .equals("Apple") && phone.getMemory() >= 64); //filter
//        filteredByMakerMemory.forEach(p -> System.out.println(p.getModel()));
        System.out.println(getModelsByMakerAndMemory("Apple", 64));

    }
    private static List<String>getModelsByMakerAndMemory(String maker, int memory){
       return getPhonesFromDB().stream()
                .filter(phone -> phone.getMaker().equals(maker) && phone.getMemory() >= memory)
                .map(Phone::getModel)
                .collect(Collectors.toList());

    }

    private static List<Phone> getPhonesFromDB() {
        List<Phone> phones = new ArrayList<>();
        Phone.Builder iPhoneBuilder = new Phone.Builder("Apple");
        Phone iPhone_x = iPhoneBuilder.setModel("iPhone X").setMemory(64).setScreenDiagonal(5.8).setButteryLife(22).build();
        Phone iPhone_7 = iPhoneBuilder.setModel("iPhone 7").setMemory(32).setScreenDiagonal(4.7).setButteryLife(18).build();
        Phone iPhone_12 = iPhoneBuilder.setModel("iPhone 12").setMemory(128).setScreenDiagonal(6.1).setButteryLife(23).build();

        Phone.Builder samsungBuilder = new Phone.Builder("Samsung");
        Phone a5 = samsungBuilder.setModel("A5").setMemory(32).setScreenDiagonal(5.2).setButteryLife(19).build();
        Phone s28 = samsungBuilder.setModel("S28").setMemory(128).setScreenDiagonal(6.2).setButteryLife(22).build();

        phones.add(iPhone_x);
        phones.add(iPhone_7);
        phones.add(iPhone_12);
        phones.add(a5);
        phones.add(s28);
        return phones;
    }
}


