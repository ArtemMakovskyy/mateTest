package main.java_basic;

public class MainPagination {
    public static void main(String[] args) {
        String [] data = {"0","1","2","3","4","5","6","7","8","9"};
        String [] data2 = {"0","1","2","3","4","5","6","7","8","9","11","12"};
//        String [] data = new String[0];
        PaginationService paginationService = new PaginationService(data2,3);
        System.out.println(paginationService.getElementsCount() + " elements");
        System.out.println(paginationService.getPageNumberByElementIndex(0));
    }
}
