package by.it.arekhava.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            try {
               Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
//                e.printStackTrace();
                printer.print(e);
            }

        }
    }
}



