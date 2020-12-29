package by.it.plehanova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static final int MAX_CASHIERS = 5;
    private final QueueBuyers queueBuyers;

    private final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private final AtomicInteger buyersCompleted = new AtomicInteger(0);
    private final AtomicInteger openCashiers = new AtomicInteger(0);
    private final AtomicInteger closeCashiers = new AtomicInteger(0);
    public static final Object monitorForOpen = new Object();
    public static final Object monitorForClose = new Object();

    void addBuyer() {
        buyersInMarket.getAndIncrement();
    }

    public Dispatcher(QueueBuyers queueBuyers) {
        this.queueBuyers = queueBuyers;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

    void goOutBuyers() {
        buyersInMarket.getAndDecrement();
        buyersCompleted.getAndIncrement();
    }

    int getBuyersInMarket() {
        return buyersInMarket.get();
    }

    int getAllBuyers() {
        return buyersInMarket.get() + buyersCompleted.get();
    }

    void closeCashier() {
        openCashiers.getAndDecrement();
    }

    void openCashier() {
        openCashiers.getAndIncrement();
    }

    int getOpenCashiers() {
        return openCashiers.get();
    }

    boolean marketIsOpened() {
        return buyersInMarket.get() + buyersCompleted.get() != PLAN;
    }

    boolean markedIsClosed() {
        return buyersCompleted.get() == PLAN;
    }


    public  boolean isNeedOpenCashier() {
        //synchronized (monitorForOpen) {
            int needToOpenCashier = queueBuyers.getQueueSize() / 5;
            if (queueBuyers.getQueueSize() % 5 > 0) {
                needToOpenCashier++;
            }
            if (openCashiers.get() < MAX_CASHIERS && needToOpenCashier > openCashiers.get()) {
                return true;
            } else {
                return false;
            }

    }

    public boolean isNeedClose() {
        //synchronized (monitorForClose) {
            int open = openCashiers.get();
            int needOpenCashier = queueBuyers.getQueueSize() / 5;
            if (queueBuyers.getQueueSize() % 5 > 0) {
                needOpenCashier++;
            }
            return needOpenCashier < open;

    }

}

