package by.it.leshchenko.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args) {

        Queue queueBuyers = new Queue(30);

        System.out.println("MARKET OPEN");
        final ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, queueBuyers);
            threadPool.execute(cashier);
        }
        int number = 0;
        while (isOpened()) {
            int count = Helper.random(2 + 1);
            for (int i = 0; i < count && isOpened(); i++) {
                final Buyer buyer = new Buyer(++number, queueBuyers);
                threadPool.execute(buyer);
            }
            Helper.sleep(ControlCentre.MARKET_ENTRY_TIMEOUT);
        }

        threadPool.shutdown();
        while (true) {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.DAYS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("MARKET CLOSE");
    }

    static boolean isOpened() {
        return ControlCentre.getBuyersInMarket() + ControlCentre.getBuyersLeft() != ControlCentre.MAX_BUYERS;
    }

    static boolean isClosed() {
        return ControlCentre.getBuyersLeft() == ControlCentre.MAX_BUYERS;
    }
}
