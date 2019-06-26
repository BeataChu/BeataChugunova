package hw3.enums;

public enum ServiceCategoryItems {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_WITH_PAGES("Tables With Pages"),
    DIFFERENT_ELEMENTS("Different Elements");

    private String text;

   ServiceCategoryItems(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
