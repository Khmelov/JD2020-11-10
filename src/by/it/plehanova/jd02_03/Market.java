package by.it.plehanova.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) {
        System.out.println("Market opened");
        QueueBuyers queueBuyers = new QueueBuyers(30);
        Dispatcher dispatcher = new Dispatcher(queueBuyers);

        ExecutorService threadPool = Executors.newFixedThreadPool(Dispatcher.MAX_CASHIERS + Dispatcher.PLAN);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i, dispatcher);
            //cashier.setRunnable(false);
            threadPool.execute(cashier);
        }

        int n = 0;

        while (dispatcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
                for (int i = 0; i <= count && dispatcher.marketIsOpened(); i++) {
                    Buyer buyer = new Buyer(++n, dispatcher);
                    if (dispatcher.getAllBuyers() % 4 == 0) {
                        buyer.setPensioner(true);
                    }
                    threadPool.execute(buyer);
                }
            Helper.sleep(1000);
        }
        threadPool.shutdown();

        while (true) {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.HOURS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");

    }
}

