package hw4.enums.values_for_data_input;

public enum Metals {
    METALS ("Metals"),
    GOLD ("Gold"),
    SILVER ("Silver"),
    BRONZE ("Bronze"),
    SELEN ("Selen");

    private String text;

    Metals(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
