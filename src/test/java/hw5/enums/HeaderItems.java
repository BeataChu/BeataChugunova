package hw5.enums;

public enum HeaderItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    private String text;

    HeaderItems(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
