package hw2;

public enum LocatorType {
    NAME ("Name"),
    CLASS_NAME ("Class name"),
    ID ("ID"),
    LINK ("Link"),
    PARTIAL_LINK ("Partial link"),
    CSS ("CSS selector"),
    XPATH ("XPath");


    private String locatorName;

    LocatorType(String locatorName) {
        this.locatorName = locatorName;
    }

    @Override
    public String toString() {
        return this.locatorName;
    }

}

