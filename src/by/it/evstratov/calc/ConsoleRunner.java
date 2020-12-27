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

        for (;;) {
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                report.endReport();
                break;
            }else if(expression.equals("printvar")){
                Var.printVar();
            }else if(expression.equals("sortvar")){
                Var.sortVar();
            }else if(expression.equals(Lang.RU)){
                lang.setLocale(new Locale("ru","RU"));
            }else if(expression.equals(Lang.BE)){
                lang.setLocale(new Locale("be","BY"));
            }else if(expression.equals(Lang.EN)){
                lang.setLocale(new Locale("en","EN"));
            }else{
                report.write(expression + "=");
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                    report.write(result.toString() + "\n");
                } catch (CalcException e) {
                    reportBuilder.writeError(e);
                    System.out.println(e.getMessage());
                }
            }

        }
    }

}
