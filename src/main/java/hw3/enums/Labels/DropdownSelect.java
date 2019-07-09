package hw3.enums.Labels;

public enum DropdownSelect implements BaseLabel {
    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    YELLOW("YELLOW");

    private String text;

    DropdownSelect(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
