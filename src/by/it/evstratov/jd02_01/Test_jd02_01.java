package by.it.evstratov.jd02_01;

import by.it.HomeWork;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class Test_jd02_01 extends HomeWork {

    private int step;
    private final PrintStream out = System.out;

    private void log(String message) {
        out.flush();
        step++;
        if (step > 1) out.println("OK");
        out.printf("%2d. %s ...", step, message);
        out.flush();
    }

    @Test(timeout = 15000)
    public void testTaskA1__Buyer() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HomeWork homeWork = run("", false);

        log("Поиск класса Buyer");
        Class<?> buyerClass = homeWork.findClass("Buyer");

        log("Проверка наследования класса Buyer");
        Class<?> superclass = buyerClass.getSuperclass();
        assertEquals(superclass, Thread.class);

        log("Проверка void методов Buyer");
        homeWork.findMethod(buyerClass, "enterToMarket");
        homeWork.findMethod(buyerClass, "chooseGoods");
        homeWork.findMethod(buyerClass, "goOut");
        Method run = homeWork.findMethod(buyerClass, "run");

        log("Поиск конструктора Buyer(int number)");
        Constructor<?> constructor = buyerClass.getConstructor(int.class);
        Object buyer = constructor.newInstance(95);

        log("Запуск метода run()");
        run.invoke(buyer);

        log("Проверка корректности вывода метода run()");
        homeWork.include("95");

        out.println("OK");
    }
}
