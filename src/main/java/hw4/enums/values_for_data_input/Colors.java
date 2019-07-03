package hw4.enums.values_for_data_input;

public enum Colors {
    COLORS("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String text;

    Colors(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
