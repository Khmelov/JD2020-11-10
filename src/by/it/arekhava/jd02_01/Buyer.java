package by.it.arekhava.jd02_01;

class Buyer extends Thread implements IByer{

    public Buyer(int number) {
        super("Buyer №"+number);

    } @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
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
    public void goOut() {
        System.out.println(this+"leave Market");
    }
}
