package by.it.plehanova.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ListCashiers {
    private static final BlockingDeque<Cashier> listCashiers = new LinkedBlockingDeque<>(5);

    static void add(Cashier cashier) {
        try {
            listCashiers.putLast(cashier);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Cashier extract() {
        return listCashiers.pollFirst();
    }

    static BlockingDeque<Cashier> getListCashiers() {
        return listCashiers;
    }

}