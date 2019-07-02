package hw4.enums.values_for_data_input;

public enum Elements {
    WATER ("Water"),
    EARTH ("Earth"),
    WIND ("Wind"),
    FIRE ("Fire");


    private String text;

    Elements(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
