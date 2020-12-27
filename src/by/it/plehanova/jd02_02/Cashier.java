package by.it.plehanova.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    private static double TOTAL_SUM = 0;


    public Cashier(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        System.out.printf("%s%s = %d\n", "-------------------------------", "ОТКРЫТЫХ КАСС", Dispatcher.getOpenCashiers());
        while (!Dispatcher.markedIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "Started service for" + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                printReceipt(buyer);
                System.out.println(this + "Finished service for" + buyer);

                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setRunnable(true);
                    buyer.notify();
                }
                if (Dispatcher.isNeedClose()) {
                    ListCashiers.add(this);
                    Dispatcher.closeCashier();
                    break;
                }

            } else {
                if (Dispatcher.getOpenCashiers() == 1) {
                    Thread.yield();
                } else {
                    ListCashiers.add(this);
                    Dispatcher.closeCashier();
                    break;
                }
            }
        }
        System.out.println(this + "closed");
        System.out.printf("%s%s = %d\n", "-------------------------------", "ОТКРЫТЫХ КАСС", Dispatcher.getOpenCashiers());
    }

    public synchronized void printReceipt(Buyer buyer) {
        synchronized (System.out) {
            ArrayList<Good> goods = buyer.getBasket().getGoodsInBasket();
            String nameOfGood;
            double priceOfGood;
            double totalSum = 0;

            int countSpace = 25;
            int countTotal = 105;
            StringBuffer space = new StringBuffer();
            StringBuffer spaceForTotalSum = new StringBuffer();
            space.append(" ".repeat(countSpace * this.number - 25));
            spaceForTotalSum.append(".".repeat(countTotal - space.length()));

            System.out.printf("%s%9s%10s%5s\n", space, "-----", this, "-----");
            System.out.printf("%s%25s\n", space, "Receipt of " + buyer);
            System.out.printf("%s%25s\n", space, "---------------------");
            for (Good good : goods) {
                nameOfGood = good.getName();
                priceOfGood = good.getPrice();
                totalSum += priceOfGood;
                System.out.printf("%s%15s | %-3.2f\n", space, nameOfGood, priceOfGood);
            }
            TOTAL_SUM += totalSum;
            int queue = QueueBuyers.getQueue().size();
            System.out.printf("%s%25s\n", space, "---------------------");
            System.out.printf("%s%15s | %-7.2f%s%7.2f$   %d - queue\n", space, "total sum", totalSum, spaceForTotalSum, TOTAL_SUM, queue);
            System.out.printf("%s%25s\n", space, "---------------------");
        }
    }

    @Override
    public String toString() {
        return "Cashier №" + number + " ";
    }
}
