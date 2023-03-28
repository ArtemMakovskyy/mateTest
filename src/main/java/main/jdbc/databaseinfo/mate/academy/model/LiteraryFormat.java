package main.jdbc.databaseinfo.mate.academy.model;

import lombok.ToString;

@ToString
public class LiteraryFormat {
    private Long id;
    private String format;

    public LiteraryFormat() {
    }

    public LiteraryFormat(String format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
