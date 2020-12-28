package by.it.evstratov.calc;

import by.it.evstratov.calc.language.ErrorLang;


public class CalcException extends Exception{

    public CalcException() {
        super();
        ConsoleRunner.logger.log(this.getMessage());
    }

    public CalcException(String message) {
        super(ConsoleRunner.lang.get(ErrorLang.ERROR)+": "+message);
        ConsoleRunner.logger.log(this.getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.lang.get(ErrorLang.ERROR)+": "+message, cause);
        ConsoleRunner.logger.log(this.getMessage());
    }

    public CalcException(Throwable cause) {
        super(cause);
        ConsoleRunner.logger.log(this.getMessage());
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ConsoleRunner.lang.get(ErrorLang.ERROR)+": "+ message, cause, enableSuppression, writableStackTrace);
        ConsoleRunner.logger.log(this.getMessage());
    }
}
