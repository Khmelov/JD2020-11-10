package by.it.leshchenko.calc;

public class CalcException extends Exception {
    private static final long serialVersionUID = 8416118025380569555L;

    public CalcException() {
        super();
        ConsoleRunner.logger.log(getMessage());
    }

    public CalcException(String message) {
        super("ERROR: " + message);
        ConsoleRunner.logger.log(getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        ConsoleRunner.logger.log(getMessage());
    }

    public CalcException(Throwable cause) {
        super(cause);
        ConsoleRunner.logger.log(getMessage());
    }
}
