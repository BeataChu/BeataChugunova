package hw3.enums;

public enum CenteredHeaders {
    EPAM_WISHES("EPAM FRAMEWORK WISHES…"),
    LOREM_IPSUM("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
            "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE" +
            " CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    JDI("JDI GITHUB"),
    JDI_URL("https://github.com/epam/JDI");

    private String text;

    CenteredHeaders(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
