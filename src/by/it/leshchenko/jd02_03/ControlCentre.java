package by.it.leshchenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class ControlCentre {
//    public static final int MARKET_OPENTIME = 120; // seconds
    public static final int MARKET_SPEED = 100; // (default - 1)
    public static final int MAX_BUYERS = 100; // default - 100



    public static final int MARKET_ENTRY_TIMEOUT = 1000; // millisecond (default - 1000)
    public static final int BUYER_CHOOSE_TIME_MIN = 500; // millisecond (default - 500)
    public static final int BUYER_CHOOSE_TIME_MAX = 2000; // millisecond (default - 500)



    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersLeft = new AtomicInteger(0);

    static void addBuyer() {
        buyersInMarket.getAndIncrement();
    }

    static void buyerLeft() {
        buyersInMarket.getAndDecrement();
        buyersLeft.getAndIncrement();
    }

    public synchronized static int getBuyersInMarket() {
        return buyersInMarket.get();
    }

    public synchronized static int getBuyersLeft() {
        return buyersLeft.get();
    }
}