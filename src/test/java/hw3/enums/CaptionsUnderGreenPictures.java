package hw3.enums;

public enum CaptionsUnderGreenPictures {
    PRACTISE("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM ("To be flexible and\ncustomizable"),
    MULTIPLATFORM ("To be multiplatform"),
    BASE ("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private String text;

    CaptionsUnderGreenPictures(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
