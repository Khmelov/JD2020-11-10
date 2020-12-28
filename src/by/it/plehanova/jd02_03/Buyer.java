package by.it.plehanova.jd02_03;

import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket;
    private final Dispatcher dispatcher;
    private static final Semaphore semaphore = new Semaphore(20);
    private boolean isPensioner;
    private boolean isRunnable;

    public Buyer(int number, Dispatcher dispatcher) {
        super("Buyer №" + number);
        this.dispatcher = dispatcher;
        dispatcher.addBuyer();
    }

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean isPensioner() {
        return isPensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.isPensioner = pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        if (this.isPensioner()) {
            System.out.println(this + " is pensioner entered to Market");
        } else {
            System.out.println(this + " entered to Market");
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " Started choose goods");
        try {
            semaphore.acquire();
            for (int i = 0; i < Helper.getRandom(1, 4); i++) {
                putGoodsToBasket();
                int timeout = Helper.getRandom(500, 2000);
                if (this.isPensioner()) {
                    timeout = (int) (timeout * 1.5);
                }
                Helper.sleep(timeout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(this + " finished choose goods");
            semaphore.release();
        }

    }

    @Override
    public void goToQueue() {

        synchronized (this) {
            dispatcher.getQueueBuyers().add(this);
            System.out.println(this + " add to queue");

            while (!this.isRunnable) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.setRunnable(false);
            System.out.println(this + " left the queue");
        }
    }

    @Override
    public void goOut() {
        try {
            basket.getGoodsInBasket().clear();
            Basket.getBasket().putLast(basket);
            System.out.println("------Осталось " + Basket.getBasket().size() + " корзин");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " leaves the Market");
        dispatcher.goOutBuyers();
    }

    @Override
    public void takeBasket() {

        try {
            basket = Basket.getBasket().take();
            System.out.println("------Осталось " + Basket.getBasket().size() + " корзин");
            System.out.println(this + " take a basket");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put a good in the basket");
        basket.putGoods(ListGoods.randomGood());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
