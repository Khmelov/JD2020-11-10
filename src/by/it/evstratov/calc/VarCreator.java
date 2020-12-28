package by.it.evstratov.calc;

import by.it.evstratov.calc.language.ErrorLang;

class VarCreator {

    public Var createVar(String strVar) throws CalcException {

        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }else if(strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if(strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }else if(Var.getVars().containsKey(strVar)){
            return Var.getVars().get(strVar);
        }else{
            throw new CalcException(ConsoleRunner.lang.get(ErrorLang.CREATE) + " " + strVar);
        }
    }

}
