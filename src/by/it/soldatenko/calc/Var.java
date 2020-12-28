package by.it.soldatenko.calc;

import java.util.*;

abstract class Var implements Operation {
    static final Map<String, Var> variables = new HashMap<>();

    public static Var save(String varName, Var varValue) {
        variables.put(varName, varValue);
        RepoVar.saveVariables(variables);
        return varValue;
    }

    public static void printVar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public static void sortVar() {
        TreeMap<String, Var> sorted = new TreeMap<>(variables);
        for (Map.Entry<String, Var> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }





    @Override
    public Var add(Var other) throws CalcException {
        String s = Language.get(Messages.OPERATION) + " " + Language.get(Messages.ADDITION)
                + " " + this + "+" + other + " " + Language.get(Messages.IMPOSSIBLE);
        Logger.INCTANCE.log(s + " " + Calendar.getInstance().getTime());

        throw new CalcException(s);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        String s = Language.get(Messages.OPERATION) + " " + Language.get(Messages.SUBTRACTION)
                + " " + this + "-" + other + " " + Language.get(Messages.IMPOSSIBLE);
        Logger.INCTANCE.log(s + " " + Calendar.getInstance().getTime());
        throw new CalcException(s);

    }

    @Override
    public Var mul(Var other) throws CalcException {
        String s = Language.get(Messages.OPERATION) + " " + Language.get(Messages.MULTIPLICATION)
                + " " + this + "*" + other + " " + Language.get(Messages.IMPOSSIBLE);
        Logger.INCTANCE.log(s + " " + Calendar.getInstance().getTime());
        throw new CalcException(s);
    }

    @Override
    public Var div(Var other) throws CalcException {
        String s = Language.get(Messages.OPERATION) + " " + Language.get(Messages.DIVISION)
                + " " + this + "/" + other + " " + Language.get(Messages.IMPOSSIBLE);
        Logger.INCTANCE.log(s + " " + Calendar.getInstance().getTime());
        throw new CalcException(s);
    }

    @Override
    public String toString() {
        return "some abstract Var{}";
    }
}
