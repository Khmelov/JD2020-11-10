package by.it.plehanova.jd02_03;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    private static double TOTAL_SUM = 0;
    private final Dispatcher dispatcher;
    private boolean isRunnable = false;

    public boolean isRunnable() {
        return isRunnable;
    }

    public void setRunnable(boolean runnable) {
        isRunnable = runnable;
    }

    public Cashier(int number, Dispatcher dispatcher) {
        this.number = number;
        this.dispatcher = dispatcher;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        while (!dispatcher.markedIsClosed()) {
            if (!this.isRunnable()) {
                if (dispatcher.isNeedOpenCashier()) {
                    synchronized (Dispatcher.monitorForOpen) {
                        this.setRunnable(true);
                        dispatcher.openCashier();
                        System.out.println("\t\t" + this + "OPENED");
                        System.out.println("-----------Открытых касс-------" + dispatcher.getOpenCashiers());
                    }
                } else {
                    continue;
                }
            } else {
                if (dispatcher.isNeedClose()) {
                    //synchronized (Dispatcher.monitorForClose) {
                    this.setRunnable(false);
                    dispatcher.closeCashier();
                    System.out.println("\t" + this + "CLOSED");
                    System.out.println("-----------Открытых касс-------" + dispatcher.getOpenCashiers());
                }
                Buyer buyer = dispatcher.getQueueBuyers().extract();
                if (buyer != null) {
                    System.out.println(this + "Started service for" + buyer);
                    int t = Helper.getRandom(2000, 5000);
                    Helper.sleep(t);
                    //noinspection SynchronizationOnLocalVariableOrMethodParameter
                    synchronized (buyer) {
                        buyer.setRunnable(true);
                        buyer.notify();
                        printReceipt(buyer);
                    }
                    System.out.println(this + "Finished service for" + buyer);
                } else {
                    if (this.isRunnable) {
                        this.setRunnable(false);
                        dispatcher.closeCashier();
                        System.out.println("\t" + this + "CLOSED");
                        System.out.println("-----------Открытых касс-------" + dispatcher.getOpenCashiers());
                    }
                }
            }
        }
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
            int queue = dispatcher.getQueueBuyers().getQueueSize();
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
