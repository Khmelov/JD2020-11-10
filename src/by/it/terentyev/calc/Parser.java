package by.it.terentyev.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Map<String,Integer> priorytyMap = new HashMap<>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };

    public Var calc(String expression) throws CalcException {
        //A=2+2*2-9
        expression = expression.replaceAll("\\s+", "");
        List<String> opperands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher.find()){
            operations.add(matcher.group());
        }
        while (operations.size()>0) {
        int index = getIndex(operations);
        String left = opperands.remove(index);
        String right = opperands.remove(index);
        String operation = operations.remove(index);
        Var result = calcOneOperation(left, operation, right);
        opperands.add(index,result.toString());
        }
        return Var.createVar(opperands.get(0));
    }

    private int getIndex(List<String> operations) {
        int index=-1;
        int prior = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            String opration = operations.get(i);
            if (prior < priorytyMap.get(opration)) {
                index=i;
                prior=priorytyMap.get(opration);
            }
        }
        return index;
    }

    private Var calcOneOperation(String leftStr,String operation, String rightStr) throws CalcException {


        Var right = Var.createVar(rightStr);
        if (operation.equals("=")) {
            return Var.save(leftStr,right);
        }
        Var left = Var.createVar(leftStr);

                switch (operation) {
                    case "+":
                        return left.add(right);
                    case "-":
                        return left.sub(right);
                    case "*":
                        return left.mul(right);
                    case "/":
                        return left.div(right);

        }
        throw new CalcException("error");
    }
}
