package by.it.plehanova.calc;


//import by.it.plehanova.calc.builder.*;
import by.it.plehanova.calc.builder2.*;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static Lang lang = Lang.INSTANCE;

    public static void main(String[] args) {
        if (args.length == 2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }

        ReportManager builder = new ReportManager();
        ReportBuilder reportShort = new ReportShort();
        builder.setBuilder(reportShort);
        builder.constructReport();
        Report shortReport = builder.getReport();



        //ReportManager builder = new ReportManager();
        ReportBuilder reportLong = new ReportLong();
        builder.setBuilder(reportLong);
        builder.constructReport();
        Report fullReport = builder.getReport();



        Scanner scanner = new Scanner(System.in);
        Parser pars = new Parser();
        Printer printer = new Printer();
        RepoVar.loadVariables();
        String expression;
        while (true) {
            expression = scanner.nextLine();
            if (expression.equals("ru")) {
                lang.setLocale(new Locale("ru", "RU"));
                System.out.println("Русский язык");
            } else if (expression.equals("be")) {
                lang.setLocale(new Locale("be", "BY"));
                System.out.println("Беларуская мова");
            } else if (expression.equals("en")) {
                lang.setLocale(new Locale("en", "UK"));
                System.out.println("English language");
            } else if (expression.equals("end")) {
                break;
            } else if (expression.equals("printvar")) {
                Var.printVar();

            } else if (expression.equals("sortvar")) {
                Var.sortVar();

            } else {
                try {
                    Var result = pars.calc(expression);
                    printer.print(result);

                } catch (CalcException e) {
                    reportShort.buildLog(e);
                    reportLong.buildLog(e);
                    printer.printErr(e);
                }
            }
        }
        fullReport.print();
        shortReport.print();

    }
}
