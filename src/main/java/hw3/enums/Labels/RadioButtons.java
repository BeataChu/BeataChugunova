package hw3.enums.Labels;

public enum RadioButtons implements BaseLabel {

    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    SELEN("SELEN");

    private String text;

    RadioButtons(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}

