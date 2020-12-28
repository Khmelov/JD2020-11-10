package by.it.plehanova.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static final Map<String, Var> variables = new HashMap<>();

    public static Map<String, Var> getVariables() {
        return variables;
    }

    public static Var save(String varName, Var varValue) {
        variables.put(varName, varValue);
        RepoVar.saveVariables(variables);
        return varValue;
    }

    public static void printVar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void sortVar() {
        TreeMap<String, Var> sort = new TreeMap<>(variables);
        for (Map.Entry<String, Var> entry : sort.entrySet()) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s + %s + %s\n", ConsoleRunner.lang.get(Error.OPERATION), this, other, ConsoleRunner.lang.get(Error.NOT_FOUND)));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s + %s + %s\n", ConsoleRunner.lang.get(Error.OPERATION), this, other, ConsoleRunner.lang.get(Error.NOT_FOUND)));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s + %s + %s\n", ConsoleRunner.lang.get(Error.OPERATION), this, other, ConsoleRunner.lang.get(Error.NOT_FOUND)));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s + %s + %s\n", ConsoleRunner.lang.get(Error.OPERATION), this, other, ConsoleRunner.lang.get(Error.NOT_FOUND)));
    }

    @Override
    public String toString() {
        return ConsoleRunner.lang.get(Error.ABSTRACT_CLASS);
    }
}
