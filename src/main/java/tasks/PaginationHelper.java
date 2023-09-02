package tasks;

import java.util.List;

public class PaginationHelper<T> {
    private final List<T> collection;
    private final int itemsPerPage;

    public PaginationHelper(List<T> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public int itemCount() {
        return collection.size();
    }

    public int pageCount() {
        int fullPages = itemCount() / itemsPerPage;
        int leftPages = itemCount() - (fullPages * itemsPerPage);
        if (leftPages == 0) {
            return fullPages;
        }
        return fullPages + 1;
    }

    public int pageItemCount(int pageIndex) {
        int fullPages = itemCount() / itemsPerPage;
        if (pageIndex + 1 < 0 || pageIndex + 1 > pageCount()) {
            return -1;
        } else if ((pageIndex + 1) <= fullPages) {
            return itemsPerPage;
        } else {
            return itemCount() - (fullPages * itemsPerPage);
        }
    }

    public int pageIndex(int itemIndex) {
        if (itemIndex > itemCount() || itemIndex <= 0) {
            return -1;
        }
        return itemIndex * 1 / itemsPerPage;
    }
}
