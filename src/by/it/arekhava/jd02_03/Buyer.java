package by.it.arekhava.jd02_03;

class Buyer extends Thread implements IByer {
    private boolean isRunnable;
private QueueByers queueByers;
    public void setRunnable(boolean runnable) {
        isRunnable = runnable;
    }

    public Buyer(int number, QueueByers queueByers) {
        super("Buyer №"+number);
        this.queueByers=queueByers;
        Dispatcher.addBuyer();

    } @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {

      //  Dispatcher.addBuyer();-ERROR need <ineed>;
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"enter to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"starter choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this+"finish choose goods");
    }

    @Override
    public void goToQueue() {
        queueByers.add(this);
        System.out.println(this+" add to Queue");
        this.setRunnable(false);
        synchronized (this){
            while (!this.isRunnable)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+" left the Queue");

    }


    @Override
    public void goOut() {
        System.out.println(this+"leave Market");
    }
}
