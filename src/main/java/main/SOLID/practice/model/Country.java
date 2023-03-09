package main.SOLID.practice.model;
//https://vertex-academy.com/tutorials/ru/perechisleniya-enum-v-java-chast-3/
enum Country {
    CANADA("CAD"),
    POLAND("PLN"),
    GERMANY("EUR"),
    LAOPAPAS,
    ZIMKABU();

    String currency;

    Country(String currency) {
        this.currency = currency;
    }

    Country() {
    }
}