package by.it.plehanova.jd02_02;

class Dispatcher {
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static final int MAX_CASHIERS = 5;
    private volatile static int buyersInMarket = 0;
    private volatile static int buyersCompleted = 0;
    private volatile static int openCashiers = 0;
    public static final Object monitorForOpen = new Object();

    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized void goOutBuyers() {
        buyersInMarket--;
        buyersCompleted++;
    }

    public static int getBuyersInMarket() {
        return buyersInMarket;
    }

    public static int getAllBuyers() {
        return buyersInMarket + buyersCompleted;
    }

    static synchronized void closeCashier() {
        openCashiers--;
    }

    public synchronized static int getOpenCashiers() {
        return openCashiers;
    }

    static boolean marketIsOpened() {
        return buyersInMarket + buyersCompleted != PLAN;
    }

    static boolean markedIsClosed() {
        return buyersCompleted == PLAN;
    }


    static void needToOpenCashier() {
        synchronized (monitorForOpen) {
            int open = openCashiers;
            int needToOpenCashier = QueueBuyers.getQueue().size() / 5;
            if (QueueBuyers.getQueue().size() % 5 > 0) {
                needToOpenCashier++;
            }
            if (needToOpenCashier > open) {
                for (int i = 0; i < needToOpenCashier - open; i++) {
                    if (open < MAX_CASHIERS) {
                        Cashier cashier = ListCashiers.extract();
                        Thread cashierThread = new Thread(cashier);
                        Market.setThread(cashierThread);
                        cashierThread.start();
                        openCashiers++;
                    }
                }
            }
        }
    }

    static synchronized boolean isNeedClose() {
        int open = openCashiers;
        int needToOpenCashier = QueueBuyers.getQueue().size() / 5;
        if (QueueBuyers.getQueue().size() % 5 > 0) {
            needToOpenCashier++;
        }
        return needToOpenCashier < open;
    }

}

