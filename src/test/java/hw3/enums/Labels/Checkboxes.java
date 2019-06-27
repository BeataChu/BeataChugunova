package hw3.enums.Labels;

public enum Checkboxes implements BaseLabel {

    WATER("WATER"),
    EARTH("EARTH"),
    WIND("WIND"),
    FIRE("FIRE");


    private String text;

    Checkboxes(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
