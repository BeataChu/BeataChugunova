// TODO package name should be in lower case
// TODO From point of view it is better put all enums near with PO
package hw3.enums.Labels;

// TODO Good catch))))
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
