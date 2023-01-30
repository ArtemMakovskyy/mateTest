package main.immutable.finalfields;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public final class Languages implements Cloneable{
    private String language;

    public Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    protected Languages clone()  {
        try {
            return (Languages)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Languages, " + e);
        }
    }
}
