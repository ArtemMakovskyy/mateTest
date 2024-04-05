package ref;

public class AnonimClasses {
    public static void some() {

        new Book("s") {
            @Override
            public String description() {
                return "new ";
            }
        };


        new ChexkAnonim(){
            @Override
            public String d() {
                return null;
            }
        };

        new ChexkAnonimd(){
            @Override
            public String d(String d) {
                return d;
            }
        };
    }

    public static void main(String[] args) {
        some();

    }
}


class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String description() {
        return "Original.";
    }

    private String somePrn() {
        return "";
    }
}

interface ChexkAnonim {
    String d();
}

interface ChexkAnonimd {
    String d(String d);
}