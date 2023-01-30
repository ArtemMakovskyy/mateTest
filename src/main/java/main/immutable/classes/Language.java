package main.immutable.classes;

import lombok.Builder;

import java.util.Objects;
@Builder
public class Language implements Cloneable{
    private String value;

    public Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;
        Language language = (Language) o;
        return Objects.equals(getValue(), language.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public Language clone()  {
        return new Language(value);
    }
}
