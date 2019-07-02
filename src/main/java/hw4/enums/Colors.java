package hw4.enums;

public enum Colors {
    COLORS ("Colors"),
    RED ("Red"),
    GREEN ("Green"),
    BLUE ("Blue"),
    YELLOW ("Yellow");

    private String text;

    Colors(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
