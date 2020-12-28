package by.it.evstratov.calc;

import by.it.evstratov.calc.language.Lang;
import by.it.evstratov.calc.language.Language;
import by.it.evstratov.calc.report.*;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static Language lang = Language.INSTANCE;
    public static Logger logger = Logger.INSTANCE;

    public static void main(String[] args) {

        CreatorReport creator = new CreatorReport();
        ReportBuilder reportBuilder = new ReportShort();
        creator.setReportBuilder(reportBuilder);
        creator.constructorReport();
        Report report = creator.getReport();
        report.startReport();
        Locale.setDefault(Locale.ENGLISH);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        RepoVar.loadVariables();

        label:
        for (;;) {
            String expression = scanner.nextLine();
            switch (expression) {
                case "end":
                    report.endReport();
                    break label;
                case "printvar":
                    Var.printVar();
                    break;
                case "sortvar":
                    Var.sortVar();
                    break;
                case Lang.RU:
                    lang.setLocale(new Locale("ru", "RU"));
                    break;
                case Lang.BE:
                    lang.setLocale(new Locale("be", "BY"));
                    break;
                case Lang.EN:
                    lang.setLocale(new Locale("en", "EN"));
                    break;
                default:
                    report.write(expression + "=");
                    try {
                        Var result = parser.calc(expression);
                        printer.print(result);
                        report.write(result.toString() + "\n");
                    } catch (CalcException e) {
                        reportBuilder.writeError(e);
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }
    }

}
