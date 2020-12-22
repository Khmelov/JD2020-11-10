package by.it.terentyev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    final static int K_SPEED=100;
    final static int PLAN=100;
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersCompleted=new AtomicInteger(0);

    static void addBuyer(){
            buyersInMarket.getAndIncrement();

    }

    static  void completeBuyer(){
        buyersInMarket.getAndDecrement();
        buyersCompleted.getAndIncrement();
    }
    static boolean marketIsOpened(){
        return buyersInMarket.get()+buyersCompleted.get()!=PLAN;
    }
    static boolean marketClosed(){
        return buyersCompleted.get()==PLAN;
    }
}
