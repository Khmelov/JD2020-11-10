package by.it.terentyev.jd02_03;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isRunnable=true;

    private QueueBuyers queueBuyers;

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Buyer(int number, QueueBuyers queueBuyers) {
        super("Buyer №" + number);
        this.queueBuyers=queueBuyers;
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        takeBasket();
        putGoodsToBasket();
        goToQueue();
         goOut();
         Dispatcher.completeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+ " started to choose goods");
        int timeout = Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+ " finished choose goods");
    }

    @Override
    public void goToQueue() {
        queueBuyers.add(this);
        System.out.println(this+" added to Queue");
        this.setRunnable(false);
        synchronized (this){
            while (!this.isRunnable)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+" left to Queue");

    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" take basket");
    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(Basket.putToBasket(Helper.random.nextInt(3)));

    }
}
