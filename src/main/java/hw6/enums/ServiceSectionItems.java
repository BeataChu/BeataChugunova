package hw6.enums;

public enum ServiceSectionItems {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with Pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    USER_TABLE("User Table");

    private String text;

    ServiceSectionItems(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
