package main.innerClases.non_static;

public class Non_Static {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public class Node {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    "value='" + value + '\'' +
                    '}';
        }
    }

}
