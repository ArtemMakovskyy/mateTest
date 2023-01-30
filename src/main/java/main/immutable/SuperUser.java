package main.immutable;

import java.util.Objects;

public class SuperUser {
    private String superProperty;

    public String getSuperProperty() {
        return superProperty;
    }

    public void setSuperProperty(String superProperty) {
        this.superProperty = superProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuperUser)) return false;
        SuperUser superUser = (SuperUser) o;
        return Objects.equals(getSuperProperty(), superUser.getSuperProperty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuperProperty());
    }
}
