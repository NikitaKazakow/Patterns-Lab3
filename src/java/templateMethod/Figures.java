package templateMethod;

public enum Figures {

    CIRCLE("Мяч"),
    SQUARE("Квадрат"),
    STAR("Звезда");

    private final String code;

    Figures(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
