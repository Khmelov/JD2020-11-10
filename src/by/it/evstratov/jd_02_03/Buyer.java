package by.it.evstratov.jd_02_03;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private boolean isPensioneer;
    private boolean isRunnable = true;
    private final QueueBuyers queueBuyers;

    public Buyer(int number, QueueBuyers queueBuyers){
        super("Buyer №"+number);
        this.queueBuyers = queueBuyers;
        Dispatcher.addBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        double timeOut = Helper.getRandom(500,2000);
        if(isPensioneer){
            timeOut *= 1.5;
        }
        putGoodsToBasket();
        Helper.sleep((int)timeOut/ Dispatcher.K_SPEED);
        System.out.println(this + " finish choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left to market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");
        this.basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        for (int i = 1; i <= Helper.getRandom(1,4); i++) {
            double timeOut = Helper.getRandom(500,2000);
            if(isPensioneer){
                timeOut *= 1.5;
            }
            Helper.sleep((int)timeOut/Dispatcher.K_SPEED);
            Good good = Good.takeRandomGood();
            this.basket.put(good);
        }
    }

    public void goToQueue(){
        System.out.println(this + " add to Queue");
        this.setRunnable(false);
        synchronized (this){
            queueBuyers.add(this);
            //Dispatcher.openNeedCashiers();
            while (!this.isRunnable) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(this + " left to Queue");
    }

    public void setRunnable(boolean iWait) {
        this.isRunnable = iWait;
    }

    public void setPensioneer(boolean pensioneer) {
        isPensioneer = pensioneer;
    }

    public boolean isPensioneer() {
        return isPensioneer;
    }

    public Basket getBasket() {
        return basket;
    }


}
