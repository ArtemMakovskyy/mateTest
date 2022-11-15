package main.clone;

import java.util.Objects;

public class Name {
    private String name;
    private String serName;

    public Name(String name, String serName) {
        this.name = name;
        this.serName = serName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", serName='" + serName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name) && Objects.equals(serName, name1.serName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serName);
    }
}
