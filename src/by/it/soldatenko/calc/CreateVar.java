package by.it.soldatenko.calc;

import java.util.Calendar;

public class CreateVar {

        static Var createVar(String operand) throws CalcException {
        operand = operand.replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else {
            if (Var.variables.containsKey(operand)) {
                return Var.variables.get(operand);
            }
        }
        String s = "Var " + operand + " " + Language.get(Messages.NOT_FOUND);
        Logger.INCTANCE.log(s + " " + Calendar.getInstance().getTime());
        throw new CalcException(s);
    }
}
