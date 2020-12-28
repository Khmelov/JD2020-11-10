package by.it.leshchenko.calc;

public class VarCreator {

    public static Var create(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches((Patterns.VECTOR))) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (Var.getVariables().containsKey(strVar)) {
            return Var.getVariables().get(strVar);
        }
        throw new CalcException("Var " + strVar + " not found");
    }
}
