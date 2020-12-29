package by.it.arekhava.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args) {
        Dispatcher.reset();
        QueueByers queueByers=new QueueByers(30);
        System.out.println("Market opened");


        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, queueByers);
           threadPool.execute(cashier);
        }


        int n=0;
        threadPool.shutdown();//no more threads

        while( Dispatcher.marketIsOpened()){
            int count= Helper.getRandom(2);
        for (int i = 1; i<=count && Dispatcher.marketIsOpened(); i++) {

                Buyer buyer = new Buyer(++n, queueByers);

                buyer.start();//threadPool.execute(buyer);
               // Dispatcher.addBuyer();
            }
            Helper.sleep(1000);
        }


        while (true) {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.DAYS)){
                    break;
                }
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }

}
