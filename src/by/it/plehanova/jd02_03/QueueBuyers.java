package by.it.plehanova.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueBuyers {

    private final BlockingDeque<Buyer> queue;

    public QueueBuyers(int maxLength) {
        queue = new LinkedBlockingDeque<>(maxLength);
    }
    public int getQueueSize() {
        return queue.size();
    }

    public void add(Buyer buyer) {
        try {
            if (buyer.isPensioner()) {
                queue.putFirst(buyer);
            } else {
                queue.putLast(buyer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Buyer extract() {
        Buyer buyer = null;
        try {
                buyer = queue.pollFirst(100, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buyer;
    }
}
