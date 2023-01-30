package main.immutable.practice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class Languages implements Cloneable{
    private String language;

    public Languages(String language) {
        this.language = language;
    }
    @Override
    protected Languages clone()  {
        try {
            return (Languages) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone Languages, " + e);
        }
    }
}
