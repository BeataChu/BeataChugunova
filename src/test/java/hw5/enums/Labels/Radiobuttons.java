package hw5.enums.Labels;

public enum Radiobuttons implements BaseLabel {

    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    SELEN("SELEN");

    private String text;

    Radiobuttons(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}

