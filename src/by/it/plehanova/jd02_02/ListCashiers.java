package by.it.plehanova.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListCashiers {
    private static final LinkedList<Cashier> listCashiers = new LinkedList<>();

    static {
        listCashiers.add(new Cashier(1));
        listCashiers.add(new Cashier(2));
        listCashiers.add(new Cashier(3));
        listCashiers.add(new Cashier(4));
        listCashiers.add(new Cashier(5));
    }

    static synchronized void add(Cashier cashier) {
        listCashiers.addLast(cashier);
    }

    static synchronized   Cashier extract() {
        return listCashiers.pollFirst();
    }

}