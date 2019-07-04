package hw5.enums;

public enum ServiceSectionItems {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    private String text;

    ServiceSectionItems(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
