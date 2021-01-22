package by.it.bogunov.jd02_02;

class Dispetcher {
    final static int K_SPEED=100;
    final static int PLAN=100;
    private volatile static int buyersInMarket=0;
    private volatile static int buyersCompleted=0;

    public static void reset() {
        buyersCompleted = 0;
        buyersInMarket = 0;
    }

    static synchronized void addBuyer(){
        buyersInMarket++;
    }

    static synchronized void completeBuyer(){
        buyersInMarket--;
        buyersCompleted++;
    }

    static boolean marketIsOpend(){
        return buyersInMarket+buyersCompleted!=PLAN;
    }
    static boolean marketIsClosed(){
        return buyersCompleted==PLAN;
    }


}
