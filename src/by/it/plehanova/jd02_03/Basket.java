package by.it.plehanova.jd02_03;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Basket {
    private static final BlockingDeque<Basket> baskets = new LinkedBlockingDeque<>(50);

    static {
        for (int i = 0; i < 50; i++) {
            try {
                baskets.put(new Basket());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

private final ArrayList<Good> goodsInBasket=new ArrayList<>();

public static BlockingDeque<Basket> getBasket(){
        return baskets;
        }

public static void putBasket(Basket basket){
        try{
        baskets.put(basket);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
        }

public ArrayList<Good> getGoodsInBasket(){
        return goodsInBasket;
        }

public void putGoods(Good good){
        goodsInBasket.add(good);
        }
        }
