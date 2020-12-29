package by.it.plehanova.calc;

class VarCreator {

    Var createVar(String operand) throws CalcException {
        operand = operand.trim().replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (Var.getVariables().containsKey(operand)) {
            return Var.getVariables().get(operand);
        }
        throw new CalcException(ConsoleRunner.lang.get(Error.VAR) + " " + operand + " " + ConsoleRunner.lang.get(Error.NOT_FOUND));
    }

}
