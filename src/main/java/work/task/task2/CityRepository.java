package work.task.task2;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    public static List<City> dataBase = new ArrayList<>(loadData());

    public static List<City> getDataBase() {
        return dataBase;
    }

    public static void setDataBase(List<City> dataBase) {
        CityRepository.dataBase = dataBase;
    }

    public static List<City> loadData() {
        City gdansk = new City(1, "gdansk");
        City bydgoszcz = new City(2, "bydgoszcz");
        City torun = new City(3, "torun");
        City warszawa = new City(4, "warszawa");

        gdansk.addNeighbor(bydgoszcz.getId(), 1);
        gdansk.addNeighbor(torun.getId(), 3);

        bydgoszcz.addNeighbor(gdansk.getId(), 1);
        bydgoszcz.addNeighbor(torun.getId(), 1);
        bydgoszcz.addNeighbor(warszawa.getId(), 4);

        torun.addNeighbor(gdansk.getId(), 3);
        torun.addNeighbor(bydgoszcz.getId(), 1);
        torun.addNeighbor(warszawa.getId(), 1);

        warszawa.addNeighbor(bydgoszcz.getId(), 4);
        warszawa.addNeighbor(torun.getId(), 1);

        return List.of(gdansk, bydgoszcz, torun, warszawa);
    }
}
