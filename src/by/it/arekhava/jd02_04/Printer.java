package by.it.arekhava.jd02_04;

import java.util.Objects;

public class Printer {
    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }
    public void print(CalcException e) {

            System.out.println(e.getMessage());

    }

    public void printErr(CalcException e) {
    }
}
