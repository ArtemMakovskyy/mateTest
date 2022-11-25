package main.java_basic;

public class PaginationService {
    private String[] data;
    private int elementsPerPage;

    public PaginationService(String[] data, int elementsPerPage) {
        this.data = data;
        this.elementsPerPage = elementsPerPage;
    }

    int getElementsCount() {
        if (data.equals(null)) {
            return 0;
        }
        return data.length;
    }

    int getPageNumberByElementIndex(int index) {
        if (index < 0 || index > getElementsCount()) {
            return -1;
        }
        if (index == 0) {
            return 0;
        }
        int pages = (int) Math.ceil((double) getElementsCount() / elementsPerPage);
        return (int) Math.ceil((double) index / elementsPerPage) - 1;
    }
}
