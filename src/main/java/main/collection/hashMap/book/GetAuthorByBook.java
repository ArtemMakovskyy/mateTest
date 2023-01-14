package main.collection.hashMap.book;
import java.util.List;
import java.util.Map;

public class GetAuthorByBook {
    public String getAuthorNameByBookTitle(Map<Author, List<Book>> authorBooks, String bookTitle) {
        String nameAuthor = null;
        for (Map.Entry<Author, List<Book>> entry : authorBooks.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).getTitle().equals(bookTitle)) {
                    nameAuthor = entry.getKey().getName();
                }
            }
        }
        return nameAuthor;
    }
    public String getAuthorNameByBookTitle2(Map<Author, List<Book>> authorBooks, String bookTitle) {
        for (Map.Entry<Author, List<Book>> entry : authorBooks.entrySet()) {
            List<Book>books = entry.getValue();
            for (Book book : books) {
                if (book.getTitle().equals(bookTitle)) {
                    return entry.getKey().getName();
                }
            }
        }
        return null;
    }
    public String getAuthorNameByBookTitle3(Map<Author, List<Book>> authorBooks, String bookTitle) {
        for (Map.Entry<Author, List<Book>> entry : authorBooks.entrySet())
            for (Book book : entry.getValue())
                if (book.getTitle().equals(bookTitle))
                    return entry.getKey().getName();
        return null;
    }
}
