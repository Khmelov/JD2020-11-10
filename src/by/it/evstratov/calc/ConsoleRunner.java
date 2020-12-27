package by.it.evstratov.calc;

import by.it.evstratov.calc.language.Lang;
import by.it.evstratov.calc.language.Language;
import by.it.evstratov.calc.report.CreateReport;
import by.it.evstratov.calc.report.ReportBuilder;
import by.it.evstratov.calc.report.ReportLong;
import by.it.evstratov.calc.report.ReportShort;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static Language lang = Language.INSTANCE;
    public static Logger logger = Logger.INSTANCE;

    public static void main(String[] args) {

        CreateReport report = new CreateReport();
        ReportBuilder reportBuilder = new ReportLong();
        report.setReportBuilder(reportBuilder);
        report.constructorReport();
        report.getReport().startReport();
        Locale.setDefault(Locale.ENGLISH);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        RepoVar.loadVariables();

        for (;;) {
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                report.getReport().endReport();
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
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    reportBuilder.writeError(e);
                    System.out.println(e.getMessage());
                }
            }

        }
    }

}
