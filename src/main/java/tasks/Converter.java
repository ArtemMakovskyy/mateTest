package tasks;

import java.text.DecimalFormat;

public class Converter {
    public float toKiloPerLiter(float mpg) {
        float delta = 4.546091F / 1.609344F;
        float rez = mpg / delta;
        float result = Math.round(rez * 100);
        return result / 100;
    }
}