package by.it.terentyev.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    private static final Deque<Buyer> deque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        deque.addLast(buyer);
    }

    static synchronized Buyer extract (){
        return deque.pollFirst();
    }
}
