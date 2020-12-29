package by.it.plehanova.jd02_06;

public class Runner {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int index = i;
            new Thread(() -> {
                Logger.getLogger().log("some text " + index);
            }).start();
        }
    }
}
