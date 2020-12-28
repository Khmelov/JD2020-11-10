package by.it.plehanova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static final List<Thread> threads = new ArrayList<>();

    public synchronized static void setThread(Thread thread) {
        threads.add(thread);
    }

    public static void main(String[] args) {
        System.out.println("Market opened");

        int n = 0;
        int t = 0;
        while (Dispatcher.marketIsOpened()) {
            t++;
            int buyersExpectedInMarket = Math.abs(Math.abs(Math.abs(t - 60) - 30) - 30) + 10;
            int count = buyersExpectedInMarket - Dispatcher.getBuyersInMarket();
            if (count > 0) {
                for (int i = 0; i <= Helper.getRandom(count) && Dispatcher.marketIsOpened(); i++) {
                    Buyer buyer = new Buyer(++n);
                    if (Dispatcher.getAllBuyers() % 4 == 0) {
                        buyer.setPensioner(true);
                    }
                    threads.add(buyer);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");

    }
}

