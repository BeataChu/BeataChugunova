package hw4;

public enum DataEnums {
    HOME_PAGE_URL("https://epam.github.io/JDI"),
    HOME_PAGE_TITLE("Home Page"),
    DEFAULT_NUMBER_OF_ENTRIES("5"),
    NUMBER_OF_ENTRIES_TO_SHOW("10"),
    TEXT_FOR_SEARCH("Custom");


    private String text;

    DataEnums(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }


}
