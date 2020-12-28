package by.it.leshchenko.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> variables = new HashMap<>();

    public static Map<String, Var> getVariables() {
        return variables;
    }

    public static Var save(String varName, Var varValue) {
        variables.put(varName, varValue);
        return varValue;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + " + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " - " + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * " + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / " + other + " невозможна");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}