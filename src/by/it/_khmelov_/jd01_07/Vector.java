package by.it._khmelov_.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : value) {
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }
}
