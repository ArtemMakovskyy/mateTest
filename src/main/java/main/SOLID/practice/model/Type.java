package main.SOLID.practice.model;

public enum Type {
    BANK ('B'), PLATINUM('p'), GOLD('g'), BASIC('b');

    char charType;

    Type(char charType) {
        this.charType = charType;
    }

    public char getCharType() {
        return charType;
    }

    public void setCharType(char charType) {
        this.charType = charType;
    }
}
