package templateMethod.figure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Figures {

    CIRCLE("Мяч"),
    SQUARE("Квадрат"),
    STAR("Звезда");

    private final String code;

    @Override
    public String toString() {
        return code;
    }
}
