package hw4.enums;

public enum HeaderMenu {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    final String text;

    HeaderMenu(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
