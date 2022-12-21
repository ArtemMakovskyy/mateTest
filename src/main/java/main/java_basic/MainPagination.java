package main.java_basic;

public class MainPagination {
    public static void main(String[] args) {
        String [] data2 = {"0","1","2","3","4","5","6","7","8","9","11","12"};
        PaginationService paginationService = new PaginationService(data2,3);
        System.out.println(paginationService.getPageNumberByElementIndex(8));

        Fighter first = new Fighter();
        first.setDamagePerHit(10);
        Fighter second = new Fighter();
        second.setHealth(30);

        FighterService fs = new FighterService();
        System.out.println(fs.willFighterWin(first, second, 5));
        // 5 ударів * 10 урону за удар = 50 урону,
        // що перевищує 30 очок здоров'я у другого бійця

        System.out.println(fs.willFighterWin(first, second, 2));
        System.out.println(fs.willFighterWin(first, second, 3));
    }
}
