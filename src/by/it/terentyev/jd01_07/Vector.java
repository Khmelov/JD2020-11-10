package by.it.terentyev.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var{

 private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

//    public Vector(String strVector) {
//        this.value = Arrays.copyOf(number(strVector), number(strVector).length);
//    }

//    private double[] number(String strVector) {
//    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : value) {
            joiner.add(Double.toString(element));
        }

        return joiner.toString();
    }
}
