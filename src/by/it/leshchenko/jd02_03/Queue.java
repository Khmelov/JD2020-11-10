package by.it.leshchenko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {

    private final BlockingDeque<Buyer> queue;

    public Queue(int count) {
        queue = new LinkedBlockingDeque<>(count);
    }

    void addBuyer(Buyer buyer) {
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    Buyer leftBuyer() {
        try {
            return queue.pollFirst(100, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}