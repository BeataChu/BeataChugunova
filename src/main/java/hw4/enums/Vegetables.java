package hw4.enums;

public enum Vegetables {
    CUCUMBER ("Cucumber"),
    TOMATO ("Tomato"),
    VEGETABLES ("Vegetables"),
    ONION ("Onion");

    private String text;

    Vegetables(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
