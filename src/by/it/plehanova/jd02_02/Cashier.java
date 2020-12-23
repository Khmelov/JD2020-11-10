package by.it.plehanova.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    private static int count = 5;

    public Cashier(int number) {
        this.number = number;
        Dispatcher.addCashier();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.markedIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                synchronized (System.in) {
                    System.out.println(this + "Started service for" + buyer);
                    int t = Helper.getRandom(2000, 5000);
                    Helper.sleep(t);
                    printReceipt(buyer);
                    System.out.println(this + "finished service for" + buyer);
                }
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setRunnable(true);
                    buyer.notify();
                }

            } else {
                synchronized (Dispatcher.cashierMonitor) {
                    if (Dispatcher.getOpenCashier() == 1) {
                        try {
                            Dispatcher.closeCashier();
                            Dispatcher.cashierMonitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void printReceipt(Buyer buyer) {
        synchronized (System.in) {
            ArrayList<Good> goods = buyer.getBasket().getGoodsInBasket();
            String nameOfGood;
            double priceOfGood;
            double totalSum = 0;
            int countSpace = 25;
            StringBuffer space = new StringBuffer("");
            for (int i = 0; i < countSpace * this.number; i++) {
                space.append(" ");
            }
            System.out.printf("%s%s%s%s\n",space, "-----",this,"-----");
            System.out.printf("%s%s\n",space, "Receipt of " + buyer);
            System.out.printf("%s%s\n",space, "---------------------");
            for (Good good : goods) {
                nameOfGood = good.getName();
                priceOfGood = good.getPrice();
                totalSum += priceOfGood;
                System.out.printf("%s%s | %-3.2f\n",space, nameOfGood, priceOfGood);
            }

            System.out.printf("%s%s\n",space, "---------------------");
            System.out.printf("%s%s | %-3.2f\n",space, "total sum", totalSum);
            System.out.printf("%s%s\n",space, "---------------------");
        }
    }

    @Override
    public String toString() {
        return "\tCashier №" + number + " ";
    }
}
